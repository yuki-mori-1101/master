package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// appパッケージに属するクラスの処理を集約するクラス
@Component
public class Fronted {
	/*
	 *  DIコンテナがインジェクションすべきフィールドであることを示す(インターフェースもクラスも指定可)
	 *  →DIコンテナは自動的に@Autowiredを付与したフィールドに対して、
	 *  →合致する型のオブジェクトを管理内のオブジェクトから探し出してインジェクションする
	 */
	@Autowired
	ArgumentResolver argumentResolver;
	@Autowired
	Calculator calculator;
	
	public void run() {
		System.out.print("Enter 2 numbers like 'a b' :");
		Argument argument = argumentResolver.resolve(System.in);
		int result = calculator.calc(argument.getA(), argument.getB());
		System.out.println("result = " + result);
	}
}
