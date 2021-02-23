/*
 ホイスティング(宣言の巻き上げ)
 　・・・コンテキスト内で宣言した変数や関数の定義をコード実行前にメモリーに配置すること。
*/

a();
function a (){
    console.log('a is called');
}
var b;
console.log(b);　//→undifined
b = 0;
console.log(b);

// console.log(c);
// →undifinedにならない。「Uncaught ReferenceError」エラー発生。constでも同様。
let c;
console.log(c);
c = 0;
console.log(c);

// d(); →「Uncaught ReferenceError」エラー発生。
const d = function (){ //無名関数の代入(関数式)
    // console.log(e); →「Uncaught ReferenceError」エラー発生。
    let e;
    console.log(e);
    function f() {
        console.log('f is called');
    }
}
d();