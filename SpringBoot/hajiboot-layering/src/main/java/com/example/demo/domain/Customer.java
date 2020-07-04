package com.example.demo.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
// 全フィールドを引数にしたコンストラクタを生成する
@AllArgsConstructor
// ドメインオブジェクトを表すクラス
public class Customer implements Serializable{
	private Integer id;
	private String firstNameString;
	private String lastName;
}
