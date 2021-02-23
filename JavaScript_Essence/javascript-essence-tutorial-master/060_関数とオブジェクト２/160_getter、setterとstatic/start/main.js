function Person1(name, age) {
	this._name = name;
	this._age = age;
}
Person1.hello = function() {
	console.log('Person1 hello');
}
//コンストラクター関数に対する、staticメソッドの定義方法
Object.defineProperty(Person1.prototype, 'name', {
	get: function() {
		console.log('hello');
		return this._name;
	},
	set: function(val) {
		this._name = val;
	}
});
const p1 = new Person1('Bob', 23);
console.log(p1.name);
p1.name = 'Tom';
console.log(p1.name);
Person1.hello();

class Person2 {
	constructor(name, age) {
		this._name = name;
		this._age = age;
	}
	get name() {
		console.log('hello')
		return this._name;
	}
	set name(val) {
		this._name = val;
	}
	static hello() {
		console.log('Person2 hello');
	}
	//classに対する、staticメソッドの定義方法
}
const p2 = new Person2('Michell', 25);
console.log(p2.constructor === Person2);
console.log(p2.name);
p2.name = 'Sun';
console.log(p2.name);
Person2.hello();