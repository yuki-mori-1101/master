// 関数は実行可能なオブジェクト！！！
function a(){
    console.log('hello');
}
a.prop = 0;
a.method = function(){
    console.log('method');
}
a();
a.method();
console.log(a.prop);1