package com.example.app;

import lombok.Data;

/* 
 * コンパイル時(classファイル作成時)に、各フィールドの以下メソッドが生成される
 * ・setter/getter → 本クラスのvフィールドはfinal修飾子が付与されているので、setterは生成されない
 * ・toStringメソッド
 * ・equalsメソッド
 * ・hashCodeメソッド
*/
@Data
public class Argument {
	private final int a;
	private final int b;
}
