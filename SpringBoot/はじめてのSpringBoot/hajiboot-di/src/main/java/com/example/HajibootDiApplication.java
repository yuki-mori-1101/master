package com.example;

import com.example.app.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* 
 * SpringBoot1.2から導入された「@SpringBootApplication」は以下の3つのアノテーションを組み合わせたもの。
 * ① @EnableAutoConfiguration
 *   →SpringBootの自走設定を有効にする
 * ② @Configuration
 *   →本クラスがJavaConfig用クラスであることを示す
 *    DIコンテナに管理させたいBeanを生成するメソッドを定義する
 * ③ @ComponentScan
 *   →@付与されているクラスのパッケージ以下の特定のアノテーションが付与されているJavaクラスを検出し、各クラスを処理する
 *    対象パッケージを変更する場合は、@backPackages属性にて指定する
 *    ・@Component:DIコンテナに登録する
 *    ・@Controller:SpringMVCのコントローラを示す
 *    ・@RestController:REST Webサービス用 (Spring4から追加)
 *    ・@Service:サービスクラスを示す (@Componentと機能的な違いはない)
 *    ・@Repository:リポジトリクラスを示す。このクラスで発生した例外はSpringが提供するDataAccessExceptionに変換される
 *    ・@Configuration:上記通り
*/
 @SpringBootApplication
 
/*
 * JavaConfigを読み込むために、@Importで@Configurationアノテーションを付与したクラスを指定
 * @Import(AppConfig.class)
*/ 
public class HajibootDiApplication implements CommandLineRunner {

	 // CommandLineRunnerインターフェースを持ったクラスは、DependencyInjectionが使用可
	 @Autowired
	 ArgumentResolver argumentResolver;
	 @Autowired
	 Calculator calculator;
	 
	 // CommandLineRunnerインターフェースのrunメソッドが、Frontedクラスのrunメソッド相当の役割を担う
	 @Override
	 public void run(String... args) throws Exception {
		 System.out.println("Enter 2 numbers like 'a b' : ");
		 Argument argument = argumentResolver.resolve(System.in);
		 int result = calculator.calc(argument.getA(), argument.getB());
		 System.out.println("result = " + result);
	 }
	 
	 public static void main(String[] args) {
		// SpringApplication.runでSpringBootアプリケーションを起動
		// 第1引数に、@EnableAutoConfigurationを付けたクラスを指定
		// 戻り値は、DIコンテナの本体であるApplicationContextになる。
//		ApplicationContext context = SpringApplication.run(HajibootDiApplication.class, args);
		 SpringApplication.run(HajibootDiApplication.class, args);
		// DIコンテナから、getBeanメソッドインスタンスを取得
		// →インスタンスの実体は、DIコンテナによって解決され、アプリケーションは意識しない
		// →アプリ内のモジュール結合度が低くなり、独立性が高くなる
//		Fronted fronted = context.getBean(Fronted.class);
//		fronted.run();
	}

}
