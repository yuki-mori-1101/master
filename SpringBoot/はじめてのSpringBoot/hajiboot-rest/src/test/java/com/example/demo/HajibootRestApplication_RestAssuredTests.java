package com.example.demo;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
		"spring.datasource.url:jdbc:h2:mem:customers;DB_CLOSE_ON_EXIT=FALSE" })
public class HajibootRestApplication_RestAssuredTests {
	@Autowired
	CustomerRepository customerRepository;
	@LocalServerPort
	int port;
	Customer customer1;
	Customer customer2;

	@Before
	public void setUp() {
		customerRepository.deleteAll();
		customer1 = new Customer();
		customer1.setFirstName("Taro");
		customer1.setLastName("Yamada");
		customer2 = new Customer();
		customer2.setFirstName("Ichiro");
		customer2.setLastName("Suzuki");

		customerRepository.saveAll(Arrays.asList(customer1, customer2));
		// RestAssuredで使用するポートの設定
		RestAssured.port = port;
	}

	@Test
	public void testGetCustomers() throws Exception {
		// GETメソッドでHTTPリクエストを送る
		when().get("/api/customers")
				.then()
				.statusCode(HttpStatus.OK.value())
				// bodyメソッドでレスポンスJSONのフィールドの値を確認
				.body("numberOfElements", is(2))
				.body("content[0].id", is(customer2.getId())).body("content[0].firstName", is(customer2.getFirstName()))
				.body("content[0].lastName", is(customer2.getLastName())).body("content[1].id", is(customer1.getId()))
				.body("content[1].firstName", is(customer1.getFirstName()))
				.body("content[1].lastName", is(customer1.getLastName()));
	}

	@Test
	public void testPostCustomers() throws Exception {
		Customer customer3 = new Customer();
		customer3.setFirstName("Nobita");
		customer3.setLastName("Nobi");

		// リクエストボディの設定。RestTemplateよりREST-assuredの方がテストコードの見通しが良い
		given().body(customer3)
				.contentType(ContentType.JSON)
				.and()
				.when()
				.post("/api/customers")
				.then()
				.statusCode(HttpStatus.CREATED.value()).body("id", is(notNullValue()))
				.body("firstName", is(customer3.getFirstName())).body("lastName", is(customer3.getLastName()));

		when().get("/api/customers").then().statusCode(HttpStatus.OK.value()).body("numberOfElements", is(3));
	}

	@Test
	public void testDeleteCustomers() throws Exception {
		when().delete("/api/customers/{id}", customer1.getId()).then().statusCode(HttpStatus.NO_CONTENT.value());

		when().get("/api/customers").then().statusCode(HttpStatus.OK.value()).body("numberOfElements", is(1));
	}
}