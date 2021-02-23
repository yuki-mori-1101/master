/*
ビルトインオブジェクト
・・・コード実行前にJSエンジンによって自動的に生成されるオブジェクト
(例)String,Object,Number,Function,Math,Boolean,Date,Symbol,etc...
*/
const arry = new Array(1,2,3,4); //=window.Array
console.log(arry);
console.log(arry[0]);
console.log(arry.hasOwnProperty(0));
console.log(arry.hasOwnProperty(4));