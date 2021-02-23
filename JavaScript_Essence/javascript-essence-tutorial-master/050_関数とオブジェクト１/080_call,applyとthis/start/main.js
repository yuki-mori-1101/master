/*
call,apply
->'this'や引数の参照先を変更する。
同時に関数を実行する。
*/
function a() {
    console.log('hello ' + this.name);
}
const tim = {name: 'Tim'};
const b = a.bind(tim); //thisの参照先をtimに指定
b();
a.apply(tim); //thisの参照先をtimに指定して実行
a.call(tim); //thisの参照先をtimに指定して実行
/*
apply->第二引数に関数の引数を配列で指定できる。
call->第二引数以下に関数の引数を指定できる。
*/

const arry = [1,2,3,4,5];
const result1 = Math.max.apply(null, arry);
console.log(result1);
const result2 = Math.max(...arry);
//->スプレッド演算子。配列を展開して、関数の引数に渡される。
console.log(result2);