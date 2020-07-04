package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@RunWith(SpringRunner.class)
// @SpringBootTestのproperties属性でテスト用にプロパティを上書き可能
// 実際のアプリケーションでは、永続可能なDBを使用している場合にテスト時にインメモリのDBを使用するという使い方ができる
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
		"spring.datasource.url:jdbc:log4jdbc:h2:mem:customers;DB_CLOSE_ON_EXIT=FALSE" })
public class HajibootRestApplicationTests {
	@Autowired
	// テストデータ投入用
	CustomerRepository customerRepository;
	@Autowired
	TestRestTemplate restTemplate;
	Customer customer1;
	Customer customer2;

	/*
	 * 全件取得APIの戻り値はPage型だがRestTemplateで取得できない※
	 * そのためにテスト用にレスポンスのJSONをマッピングするJavaクラスを用意
	 * ここでは、後述のテストで使用するフィールド(content,numberOfElements)のみを定義する
	 * レスポンスのJSONには、存在する他フィールドを無視するために@JsonIgnorePropertiers(ignoreUnknown=true)を付与
	 * 
	 * ※.デフォルトではマッピング対象のクラスにデフォルトコンストラクタ、setter/getter、が必要。
	 * Pageインターフェースの実装クラスPageImplクラスはこれらメソッドをもたないためにRestTempalteにマッピングできないのでSpringData側での対応が必要
	 */
	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	static class Page<T> {
		private List<T> content;
		private int numberOfElements;
	}

	// テストの初期化。
	// テストデータを全件削除した後に改めてテストデータを投入する。JUnitのテスト実行順は不定であるため、状態をリセットする必要
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
	}

	// 全件取得APIのテストを作成する
	@Test
	public void testGetCustomers() throws Exception {
		// TestRestTemplateの汎用リクエストメソッドであるexchangeを使用して、テスト用のリクエストを送る
		ResponseEntity<Page<Customer>> response = restTemplate.exchange("/api/customers", HttpMethod.GET,
				// 戻り値がジェネリクス(汎用)である場合はParameterizedTypeReferenceを使用して型を特定する
				null /* body,header */, new ParameterizedTypeReference<Page<Customer>>() {
				});
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getNumberOfElements()).isEqualTo(2);

		Customer c1 = response.getBody().getContent().get(0);
		assertThat(c1.getId()).isEqualTo(customer2.getId());
		assertThat(c1.getFirstName()).isEqualTo(customer2.getFirstName());
		assertThat(c1.getLastName()).isEqualTo(customer2.getLastName());

		Customer c2 = response.getBody().getContent().get(1);
		assertThat(c2.getId()).isEqualTo(customer1.getId());
		assertThat(c2.getFirstName()).isEqualTo(customer1.getFirstName());
		assertThat(c2.getLastName()).isEqualTo(customer1.getLastName());
	}

	// 新規作成APIのテスト
	@Test
	public void testPostCustomers() throws Exception {
		Customer customer3 = new Customer();
		customer3.setFirstName("Nobita");
		customer3.setLastName("Nobi");

		// HttpEntityクラスを用いて、リクエストボディを作成する
		ResponseEntity<Customer> response = restTemplate.exchange("/api/customers", HttpMethod.POST,
				new HttpEntity<Object>(customer3) /* (8) */, Customer.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		Customer customer = response.getBody();
		assertThat(customer.getId()).isNotNull();
		assertThat(customer.getFirstName()).isEqualTo(customer3.getFirstName());
		assertThat(customer.getLastName()).isEqualTo(customer3.getLastName());

		assertThat(restTemplate
				.exchange("/api/customers", HttpMethod.GET, null, new ParameterizedTypeReference<Page<Customer>>() {
				}).getBody().getNumberOfElements()).isEqualTo(3);
	}

	// 1件削除APIのテスト
	@Test
	public void testDeleteCustomers() throws Exception {
		// パス中のパラメータはプレースホルダを利用して埋めることができる
		ResponseEntity<Void> response = restTemplate.exchange("/api/customers/{id}", HttpMethod.DELETE,
				null /* body,header */, Void.class, Collections.singletonMap("id", customer1.getId()));
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

		assertThat(restTemplate
				.exchange("/api/customers", HttpMethod.GET, null, new ParameterizedTypeReference<Page<Customer>>() {
				}).getBody().getNumberOfElements()).isEqualTo(1);
	}

}