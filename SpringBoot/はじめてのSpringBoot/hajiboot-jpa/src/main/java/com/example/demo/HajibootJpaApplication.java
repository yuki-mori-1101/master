package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootApplication
public class HajibootJpaApplication implements CommandLineRunner {
	
	// 依存ライブラリにspring-boot-jdbcとjdbcドライバを追加することで、
	// DataSourceやJdbcTemplateやNamedParameterJdbcTemplateが自動で生成され、DIコンテナに登録される
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
    public void run(String...strings) throws Exception{
        Customer created = customerRepository.save(new Customer(null,"Hideyoshi","Dekishugi"));
        System.out.println(created + "is created!");
        customerRepository.findAllOrderByName().forEach(System.out::println);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(HajibootJpaApplication.class, args);
	}
}
