package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// ↓のアノテーションにより、様々な設定が自動的に有効になり、従来のSpringアプリケーションで必要だった設定ファイル群が不要になる。
@SpringBootApplication
// ↓のアノテーションにより、本クラスがWebアプリケーションにおいて、リクエストを受け付けるコントローラクラスになることを示す。
@RestController
public class DemoApplication {

	// ↓のアノテーションにより、HTTPリクエストをGETメソッドで受け付けるためのメソッドであることを示す。
	// このアプリケーションに「/」というパスでアクセスがあった場合にhomeメソッドが呼ばれる。
	@GetMapping("/")
	String home(){
		// HTTPレスポンスを記述。「@RestController」アノテーションが付いているクラスのメソッドで文字列を返した場合は、
		// その文字列がそのままHTTPレスポンスとして出力される。
		return "Hello,Spiring Boot!";
	}

	// SpringBootアプリケーションを実行するための処理をmainメソッド内に記述。
	// SpringApplication.runメソッドの第1引数に「@SpringBootApplication」アノテーションをつけたクラスを指定する。
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
