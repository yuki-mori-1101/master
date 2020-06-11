let mynam = '田中一郎';
let heigh = 176;

/*
TypeScriptでは、型宣言しなくても最初に代入された値によって型推測されて、型を決定する。
let mynam = '田中一郎'; -> mynamはString型
let heigh = 176;       -> heighはint型
*/

// 以下は、決定された型とは異なる型を代入しているのでエラーになる
// mynam = 10;
// heigh = 'わからない';