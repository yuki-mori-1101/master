
// 型宣言はTypeScriptの機能の為に、JavaScriptには反映されない

// ES6以前の関数宣言
function sm_beforeES6(a: number, b: number): number {
    return a * b;
}
// ES6以降の関数宣言
const sm_afterES6 = (a: number, b: number): number => {
    return a * b;
}

let ans: number = sm_beforeES6(5, 2);
console.log(ans);
