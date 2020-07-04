package com.example.demo.service;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// サービスを表すクラス
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public List<Customer> findAll(){
		return customerRepository.finadAll();
	}
}
