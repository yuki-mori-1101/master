package com.example.demo.repository;

import com.example.demo.domain.Customer;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*
 * JPARepositoryには以下メソッドが定義されている。
 * 起動時にエンティティに対応したテーブルの削除(drop table)、作成(create table)がデフォルトで実行される
 * ・Create:saveメソッド
 * ・Read:findOne, findAllメソッド
 * ・Update:
 * ・Delete:delete
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	/*
	 *  JpaRepositoryに定義されていない検索処理などを実行したい場合は、本インターフェースに対応するメソッドを追加。
	 *  JPQL(JPAのエンティティ操作用の問合せ言語で、実行時にSQLに変換される。RDBMSには依存しない。
	 */
	// JPQLを記述する。native=trueを指定するとSQLを使用できるがRDBMSに依存してしまう。
	@Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
	List<Customer> findAllOrderByName();
}
