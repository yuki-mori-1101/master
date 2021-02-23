/*
Promise・・・
非同期処理をより簡単に、可読性が上がるように
書けるようにしたもの。
===Promise構文===========================
new Promise(function(resolve, reject) {
    resolve("hello"); <-同期処理
}).then(function(data) {
    console.log(data);->hello <-非同期処理(コールスタックが空になってから実行)
}).catch(
    <-非同期処理(コールスタックが空になってから実行)
).finally(function() {
    console.log("終了処理");
});
========================================
new Promise(function(resolve, reject) {
    reject("bye");  <-同期処理
}).then(function(data) {
    <-非同期処理
}).catch(
    console.log(data);->bye <-非同期処理(コールスタックが空になってから実行)
).finally(function() {
    console.log("終了処理");
});
*/
new Promise(function(resolve, reject) {
    // 同期処理
    console.log('promise');
    // reject("bye");
    setTimeout(function() {
        resolve("hello");
    }, 1000);
}).then(function(data) {
    // 非同期処理
    console.log('then1: ' + data);
    // throw new Error(); //->catchへ
    return data;
}).then(function(data) {
    // 非同期処理
    console.log('then2: ' + data);
    return data;
}).catch(function(data) {
    // 非同期処理
    console.log('catch ' + data);
}).finally(function(data) {
    // 非同期処理
    console.log('finally: ' + data);
    //finallyには引数を渡せない
})
console.log('global end');