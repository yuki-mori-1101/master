// グローバルコンテキスト
let a = 0;
function b() {
    // 関数コンテキスト
    console.log(this, arguments, a);
    // this→windowオブジェクト, a→外部変数
}

// console.log(a);
b();