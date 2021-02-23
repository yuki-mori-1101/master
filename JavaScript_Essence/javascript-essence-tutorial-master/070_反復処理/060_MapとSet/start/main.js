/*
Object
->キー:文字列
  for...in:使用可/for...of:使用不可
Map
->キー:制約なし
  for...in:使用不可/for...of:使用可
Array
->重複値:可/for...in:使用可/for...of:使用可
Set
->重複値:不可/for...in:使用不可/for...of:使用可
*/
const map = new Map();
const key1 = {};

map.set(key1, 'value1');
console.log(map.get(key1));
console.log(map.get({}));
//->key1のオブジェクトの参照でなければ×

const key2 = function(){};
map.set(key2, 'value2');
console.log(map.get(key2));
console.log(map.get(function(){}));
//->key1の関数の参照でなければ×

let key3;
map.set(key3=0, 'value3');
console.log(map.get(key3));
console.log(map.get(0));

map.delete(key3);
console.log(map.get(key3));

console.log('======================');

for(const [k, v] of map) {
    console.log(k, v);
}

console.log('======================');

const s = new Set();
s.add(key1);
s.add(key1);
s.add(key2);
s.add(key3);
s.delete(key3);
console.log(s.has(key2));

// const arry = Array.from(s);
const arry = [...s];
//->スプレッド構文
console.log(arry);

for(let k of s) {
    console.log(k);
}


