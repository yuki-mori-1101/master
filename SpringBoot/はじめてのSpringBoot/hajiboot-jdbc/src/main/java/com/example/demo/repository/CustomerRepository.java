package com.example.demo.repository;

import com.example.demo.domain.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.PostConstruct;
//リポジトリを表すクラス
@Repository
/*
 * クラスレベルに付与したクラスをDIコンテナから取得すると、そのクラスの各メソッドが他クラスから呼ばれた場合、自動的にDBトランザクションの制御が行われる
 * メソッドが正常終了→DBトランザクションのコミット / 実行時例外の発生(※)→DBトランザクションのロールバック / ※→チェック例外の場合はロールバックされない
 * DIコンテナによって、各メソッドに前後処理が追加されたクラスが動的に生成される
 */
 @Transactional
public class CustomerRepository {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	SimpleJdbcInsert insert;
	
	@PostConstruct
	public void init() {
		// SimpleJdbcInsertには、jdbcTemplateを設定する必要があるため、
		// NamedParameterJdbcTemplateに内包されているjdbcTemplateオブジェクトを取得する
		insert = new SimpleJdbcInsert((JdbcTemplate) jdbcTemplate.getJdbcOperations())
				// SimpleJdbcInsertはINSERTのSQLを自動生成するのでテーブル名を明示的に指定する
				.withTableName("customers")
				// 自動採番される主キーのカラム名を指定
				.usingGeneratedKeyColumns("id");
	}
	
	// ResultSetをJavaオブジェクトに変換するためのRowMapperは他メソッドで使用するためにフィールドに持たせる
	private static final RowMapper<Customer> customerRowMapper = (rs, i) -> {
		Integer id = rs.getInt("id");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		return new Customer(id, firstName, lastName); 
	};
	
	// NamedAParameterJdbcTemplateのqueryメソッドを用いて、SQLの実行結果をJavaオブジェクトのリストとして取得
	public List<Customer> finadAll(){
		List<Customer> customers = jdbcTemplate.query(
				"SELECT id,first_name,last_name FROM customers ORDER BY id",
				customerRowMapper);
		return customers;
	}
	
	public Customer findOne(Integer id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		return jdbcTemplate.queryForObject(
				"SELECT id,first_name,last_name FROM customers WHERE id=:id",
				param,
				customerRowMapper);
	}
	
	public Customer save(Customer customer) {
		// 更新用のSqlParameterSourceを作成する
		// BeanPropertySqlParameterSourceを使用することで、Javaオブジェクトに
		// フィールド名と値をマッピングしたSqlParameterSourceが自動的に生成される
		SqlParameterSource param = new BeanPropertySqlParameterSource(customer);
		// 更新用のSQLを実行するためにNamedParameterJdbcTemplateのupdateメソッドを使用する
		if(customer.getId() == null) {
			// SQLの実行と自動採番されたidを戻り値に返す
			Number key = insert.executeAndReturnKey(param);
			customer.setId(key.intValue());
		} else {
			jdbcTemplate.update(
					"UPDATE customers SET first_name=:first_name, last_name=:last_name WHERE id=:id",
					param);
		}
		return customer;
	}
	
	public void delete(Integer id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		jdbcTemplate.update(
				"DELETE FROM customers WHERE id=:id",
				param);
	}
}
