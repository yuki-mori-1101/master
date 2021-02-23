function hello(name){
    console.log('hello' + name);
}
function bye(){
    console.log('bye');
}
function fn(cb){
    cb('Tom');
}
fn(hello); //->helloがコールバック関数
fn(bye); //->byeがコールバック関数
fn(function(name){ //->無名関数
    console.log('hello' + name);
})

setTimeout(hello, 2000);
//->第二引数に指定してミリ秒後に第一引数のオブジェクトを実行する