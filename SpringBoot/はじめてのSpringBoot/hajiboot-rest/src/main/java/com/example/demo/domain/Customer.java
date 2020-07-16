package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// JPAのエンティティであることを示す
@Entity
// エンティティに対応するテーブル名を指定する。デフォルトではテーブル名=クラス名
@Table(name = "customers")
@Data
// エンティティクラスに必要な引数の無いデフォルトコンストラクタを生成する
@NoArgsConstructor
// 全フィールドを引数にしたコンストラクタを生成する
@AllArgsConstructor
// ドメインオブジェクトを表すクラス
public class Customer {
	// エンティティの主キーであるフィールド
	@Id
	// 主キーがDBで自動採番されることを示す
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// 該当するDBのカラムに対する名前や制約などを設定する
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
}
