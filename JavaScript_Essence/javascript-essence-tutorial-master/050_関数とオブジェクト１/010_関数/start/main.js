function fn1(a, b){
    console.log(a, b);
}
function fn1(a, b){
    console.log(2);
}
/*
JavaScriptでは、引数は関係なく、関数名のみの判断で呼び出す関数が決定される
->同名の関数を避けたければ、constで定義する
const fn = function(a, b){
    console.log(a, b);
}
*/
fn1(1, 2);

const fn2 = function(a, b=1) {
    console.log(arguments);
    console.log(a, b);
}
fn2(1);
fn2(1, null); //nullの場合はデフォルト値がbに入らない
fn2(1, undefined); //undefinedの場合にデフォルト値bに入る7

const fn3 = function(...args) {
    console.log(args);
    const a = arguments[0];
    const b = arguments[1];
    console.log(a, b);
}
fn3();

const fn4 = function(){
    const a = 0;
    return a; 
}
let c = fn4();//->returnが無い場合は、cにundefinedが入る
console.log(c);