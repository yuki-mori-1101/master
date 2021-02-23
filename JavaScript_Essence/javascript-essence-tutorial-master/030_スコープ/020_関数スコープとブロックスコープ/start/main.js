function a(){
    let b = 0;
    console.log(b);
}
// console.log(b); UncaughtError発生
a();

// JavaScriptでは「{}」がブロックと表現される
{
    // ブロックスコープを使用する場合はlet,constを使用する
    // varではブロックスコープを使用できない
    let b = 0;
    const c = 0;
    var d = 0;
    console.log(b);
    console.log(c);
    // 関数宣言ではブロックスコープにならない
    function e(){
        console.log('e is called');
    }
    const f = function(){
        console.log('f is called');
    }
    f();
}
// console.log(b); UncaughtError発生
// console.log(c); UncaughtError発生
console.log(d);
e();
// f(); UncaughtError発生