/*
for...of・・・
   イテレーターを持つオブジェクトの反復操作を行う
イテレーター・・・
   反復操作を行う際に使用するオブジェクト
   Map,Array,String,arguments,etc...
   ->反復可能オブジェクト
*/
const arry = ['a', 'b', 'c'];
arry[4] = 'e';
Object.defineProperty(
    arry,
    0,
    {enumerable: false}
);
//for...ofではenumerableがfalseでも
//列挙対象になる(enumerable)参照されない
for(let v of arry){
    console.log(v);
}