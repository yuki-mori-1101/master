/*
 レキシカルスコープ・・・
 　①実行中のコードから見た外部スコープのこと
 　②どのようにしてスコープを決定するかの仕様のこと(静的スコープ)
 */


let a = 2;
function fn1(){
    let b = 1;
}
fn1();

function fn2(){
    let c = 3;
    console.log(b);
}
fn2();

// 本クラスのグローバルスコープ→a,fn1
// 本クラスの関数スコープ(fn1)→b,fn2
// 本クラスの関数スコープ(fn2)→c