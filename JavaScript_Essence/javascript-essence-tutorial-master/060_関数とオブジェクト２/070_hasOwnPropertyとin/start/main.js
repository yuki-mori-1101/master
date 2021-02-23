function Person(name, age) {
    this.name = name;
    this.age = age;
}

Object.prototype.hello = function() {
    console.log('Object: hello ' + this.name);
}

const bob = new Person('Bob', 18);
const result1 = bob.hasOwnProperty('name');
console.log(result1);
const result2 = bob.hasOwnProperty('hello');
//->hasOwnPropertyは、自身のプロパティに存在しているか確認する
console.log(result2);
console.log('name' in bob);
//->自身のプロパティ、または__proto__に、引数のプロパティかメソッドが存在しているか
//  プロトタイプチェーンを遡って確認する
console.log('hello' in bob);