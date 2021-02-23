/*
クロージャー・・・
　レキシカルスコープの変数を関数が使用している状態
　(例)
　グローバルスコープ→fn1
　関数スコープ(fn1)→b, fn2
　関数スコープ(fn2)→console.log(b) →クロージャー
*/


function incrementFactory(){
    let num = 0;

    function increment(){
        num = num + 1;
        console.log(num);
    }
    //JavaScriptでは関数を戻り値にできる。また、メソッド名の前に戻り値の定義も不要。
    return increment;
}
// console.log(num) → スコープ外なので「UncaughtError」発生

const increment = incrementFactory();
increment();
increment();
increment();
