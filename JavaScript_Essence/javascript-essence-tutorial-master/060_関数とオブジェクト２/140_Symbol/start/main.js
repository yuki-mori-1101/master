/*
シンボル
・・・プロパティーの重複を避ける為に、必ず一意の値を返す関数。プリミティブ。
*/
const s1 = Symbol('hello');
const s2 = Symbol('hello');
console.log(s1);
console.log(s2);
console.log(s1 === s2);
console.log(typeof s1);

const str = new String('Tom');
console.log(typeof str);
console.log(str);

String.prototype[s1] = function() {
    return 'hello ' + this;
}

const tom = 'Tom';
console.log(tom[s1]());