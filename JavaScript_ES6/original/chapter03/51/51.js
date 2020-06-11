"use strict";
var X = 1;
// let X: any とすれば、数値を代入した後に文字列を代入できる。
// が、anyは、過去のJavaScriptとの互換性の為に準備されている型なので、あまり使用しない方が吉。
var Y = 2;
// X = '文字列を代入します';
console.log(X * Y);
