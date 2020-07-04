package com.example.demo;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HajibootJdbcApplication implements CommandLineRunner {
	
	// 依存ライブラリにspring-boot-jdbcとjdbcドライバを追加することで、
	// DataSourceやJdbcTemplateやNamedParameterJdbcTemplateが自動で生成され、DIコンテナに登録される
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// データ追加
		Customer created = customerRepository.save(new Customer(null, "Hidetoshi", "Dekisugi"));
		System.out.println(created + " is created!");
		// データ表示 (リストの各データに対して、forEachメソッドの引数に渡されたラムダ式を適用する
		// System.out::printlnはメソッド参照で、「(x) -> {System.out.println(x);」
		customerRepository.finadAll().forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HajibootJdbcApplication.class, args);
	}

}
