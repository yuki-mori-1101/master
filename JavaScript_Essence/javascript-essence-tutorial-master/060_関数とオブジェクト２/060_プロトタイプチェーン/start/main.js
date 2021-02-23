/*
プロトタイプチェーン・・・プロトタイプの多重形成
*/
function Person(name, age) {
  this.name = name;
  this.age = age;
  this.hello = function() {
    console.log('OwnProperty: hello ' + this.name);
  }
}
// Person.prototype.hello = function() {
//   console.log('Person: hello ' + this.name);
// }
 Object.prototype.hello = function() {
  console.log('Object: hello ' + this.name);
}
const bob = new Person('Bob', 18);
bob.hello();
/*
helloの探索順序
->bobオブジェクト自身
->bob.__proto__(=prototype=Person.hello)
->bob.__proto__.__proto__(=prototype=Object.hello)
*/
const result = bob.hasOwnProperty('name');
//->ObjectプロパティのhasOwnPropertyを呼出している
console.log(result);