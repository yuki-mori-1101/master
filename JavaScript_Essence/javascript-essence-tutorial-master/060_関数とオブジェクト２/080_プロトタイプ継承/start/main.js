/*
プロトタイプ継承
・・・別のコンストラクター関数のプロトタイプを引き継いで、機能を流用できるようにすること。
継承
・・・別のコンストラクター関数を受け継ぐこと。
*/
function Person(name, age) {
  this.name = name;
  this.age = age;
}
Person.prototype.hello = function() {
  console.log('Person: hello ' + this.name);
}

function Japanese(name, age, gender){
  Person.call(this, name, age);
  this.gender = gender;
}
Japanese.prototype = Object.create(Person.prototype);
Japanese.prototype.hello = function() {
  console.log('Japanese: hello ' + this.name);
}
Japanese.prototype.sex = function() {
  console.log('Japanese: gender ' + this.name);
}
const taro = new Japanese('taro', 23, 'Male');
taro.hello();
//->Japaneseのprototypeに格納されたhelloが先に見つかって実行される
taro.sex();