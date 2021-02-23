//関数は実行可能なオブジェクトである

let d = 0;
function fn(){
    let d = 1;
    const fn1 = new Function('a' ,'b', 'return a * b * d');
    //関数コンストラクタは、渡ってくる引数を文字列として定義する
    //関数コンストラクタの引数に外部変数(d)には、グローバルスコープからもってくる
    return fn1;
}
function fn2(a, b){
    return a + b;
}
const f = fn();
console.log(f);
const result = f(1, 2);
console.log(result);
console.log(fn instanceof Function);
console.log(fn2 instanceof Function);

const obj1 = new function(){
    this.a = 0;
}
//->無名関数で生成されたオブジェクト
const fn3 = new Function('return;');
//->関数コンストラクタで生成された関数オブジェクト
const obj2 = new fn3();
//->関数オブジェクトで生成されたオブジェクト
console.log(obj1);
console.log(fn3);
console.log(obj2);