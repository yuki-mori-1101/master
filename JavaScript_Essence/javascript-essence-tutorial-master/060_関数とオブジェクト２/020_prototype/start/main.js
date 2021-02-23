/*
プロトタイプ
->オブジェクトに存在する特別なプロパティー
->コンストラクター関数とあわせて使用
*/
function Person(name, age) {
    this.name = name;
    this.age = age;
    // this.hello = function(){
    //     console.log(`hello ${this.name}`)
    // }
}
Person.prototype.hello = function() {
    console.log(`hello ${this.name}`)
}
//personの「__proto__」にhelloメソッドが格納される
const bob = new Person('Bob', 18);
const tom = new Person('Tom', 33);
const sun = new Person('Sun', 20);
bob.hello();
//Person.prototype===bob.__proto__=>true
tom.hello();
sun.hello();

/*
prototypeを使用しない場合
->インスタンスごとに、
   function(への参照であるhello)を保持
  Person.hello=>function1
  bob.hello=>function2
  tom.hello=>function3
  ->メモリ無駄遣い
prototypeを使用する場合
->共通のfunctoin(への参照である__proto__を保持)
  Person.prototype.hello=>function1
  bob.__proto__.hello=>function1
  tom.__proto__.hello=>function1
  ->メモリ効率化

インスタンス化した際にはprototypeの参照が
 __proto__にコピーされる
*/