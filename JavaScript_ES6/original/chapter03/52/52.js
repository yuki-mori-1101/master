"use strict";
// 型宣言はTypeScriptの機能の為に、JavaScriptには反映されない
// ES6以前の関数宣言
function sm_beforeES6(a, b) {
    return a * b;
}
// ES6以降の関数宣言
var sm_afterES6 = function (a, b) {
    return a * b;
};
var ans = sm_beforeES6(5, 2);
console.log(ans);
