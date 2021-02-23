let a = 0;
function fn1(arg1){
    arg1 = 1;  //プリミティブ型のコピー
    console.log(a, arg1);
}
fn1(a);

let b = {
    prop: 0
}
function fn2(arg2){
    arg2.prop = 1;
/*
arg2にはオブジェクトの参照であるbが代入される(=オブジェクトのコピー)ので、
参照先のpropの値が変更されることになる。
*/
    console.log(b, arg2);
}
fn2(b);

let c = {
    prop: 0
}
function fn3(arg2){
    arg2 = {}; // オブジェクトの再代入
    console.log(c, arg2);
}
fn3(c);