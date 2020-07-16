package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

// JUnitのテスト内でSpringの機能を使用できる
@RunWith(SpringRunner.class)
// @SpringBootTest→SpringBootのテスト機能を有効化。WebEnvironmentにRANDOM_PORTを指定→空いているポートに組み込みサーバが起動する
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {
	// WebEnvironment.RANDOM_PORTで立ち上がったサーバのポート番号をインジェクション
	@LocalServerPort
	int port;
	@Autowired
	/*
	 * 立ち上げた組み込みサーバにアクセスするためのHTTPクライアントを用意
	 * TestRestTemplateはRestTemplateに比べて、エラーが発生しても処理を続行したり、Basic認証の設定が簡単にできる、
	 * などテスト用の設定が追加されている
	 */
	TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
		/*
		 * TestRestTemplateのgetForEntityでHTTPのGETに相当するリクエストを実施
		 * 第二引数にレスポンスボディ、第三引数にシリアライズする型を指定
		 */
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port, String.class);
		// TestRestTemplateを使用する場合は、「プロトコル://ホスト名:ポート番号」を省略してパスから指定できる
		// ResponseEntity<String> response = restTemplate.getForEntity("/",
		// String.class);

		// ResponseEntityにHTTPレスポンスのステータスコードやヘッダ、ボディが格納されている
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo("Hello World!");
	}

}