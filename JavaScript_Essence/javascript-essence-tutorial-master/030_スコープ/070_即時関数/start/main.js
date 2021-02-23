/*
　即時関数・・・
　　関数定義と同時に一度だけ実行される関数。実行結果が戻り値に返される。
　　一度しか使用しないメソッドの場合や関数内でブロック外で宣言済みの変数名を
　　使用したい場合に即時関数が使用される。
　　(例)
　　let result = (function(仮引数){
        return 戻り値;
    })(実引数);
    →実引数に渡された値が仮引数に渡されて実行される
*/

function a(){
    console.log('called');
}
// 以下①〜③は同義
a(); //①
(a)(); //②  
(function(){ //③
    console.log('called1');
})();

let b = (function(num){
    console.log('called' + num);
    return 0;
})(2);//変数に関数式を代入する場合、末尾に「()」を付けると即時実行されてから代入される
console.log(b);

// 変数に関数式を代入する場合、末尾に「()」を付けると即時実行されてから代入される。
let c = function() {
    console.log('called3');
    return 10;
}();

let d = (function() {
    let privateVal = 0;
    let publicVal = 10;
    function privateFn() {
        console.log('privateFn is called');
    };
    function publicFn() {
        console.log('publicFn is called' + privateVal++);
    };
    return {
        publicVal,
        publicFn
    };
})();
console.log(d);
console.log(d.publicVal);
d.publicFn();
d.publicFn();