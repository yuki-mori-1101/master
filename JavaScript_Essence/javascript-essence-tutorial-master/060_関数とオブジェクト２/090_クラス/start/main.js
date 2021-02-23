/*
クラス
・・・コンストラクター関数をクラス表記で書けるようにしたもの
->既にある機能を簡単に書けるようにしたもの=シンタックスシュガー
*/

class Person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }
  hello() {
    console.log('hello ' + this.name);
  }
}

const bob = new Person('Bob', 23);
console.log(bob);
//->JavaScriptでは、インスタンス化されたものはオブジェクトになる

// function Person(name, age) {
//   this.name = name;
//   this.age = age;
// }

// Person.prototype.hello = function() {
//   console.log('hello ' + this.name);
// }

