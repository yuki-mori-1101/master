/*
* コンストラクタ関数
* ->新しくオブジェクトを作成する為の雛形となる関数
*/
function Person(name, age){
    this.name = name;
    this.age = age;
}

const bob = new Person('Bob', '18');
const tom = new Person('Tom', '18');
const sun = new Person('Sun', '18');