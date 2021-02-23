/*
スプレッド演算子
・・・反復可能や列挙可能なオブジェクトの展開を行う
     let a = [...array]
     {},[]の中で使用
     ->スプレッド演算子はイテレーターの操作に従う
残余引数(Rest Parameter)
・・・実引数に渡された変数を配列にまとめる
     function(...args)
*/
const arry1 = [1,2,3,4,5];
const arry2 = [...arry1];//<-参照でない。
console.log(arry1 === arry2);

function sum(...args) {
    let sum = 0;
    for(let v of args) {
        sum += v;
    }
    return sum;
}
const result = sum(1,2,3,4);
console.log(result);

const obj1 = {
    prop1: 'value1',
    prop2: 'value2',
    prop3: 'value3'
}
Object.prototype[Symbol.iterator] = function*() {
    for(let key in this) {
        yield [key, this[key]];
    }
}
const arry3 = [ ...obj1 ];
//->オブジェクトを配列にして格納。イテレーターの必要あり。
console.log(arry3);
const arry4 = { ...obj1 };
//->オブジェクトとして格納。イテレーターの定義必要なし。
console.log(arry4);