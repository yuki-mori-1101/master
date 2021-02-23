/*
コンストラクター関数の戻り値がオブジェクト以外
もしくは、returnが定義されていない場合
->new
オブジェクトの__proto__に、
コンストラクターのprototypeをコピー。
このオブジェクトを'this'の参照先として、
コンストラクター関数を実行する。
*/
function F(a, b){
    this.a = a;
    this.b = b;
    return {};
}
function G(a, b){
    this.a = a;
    this.b = b;
    return 1;
}
function H(a, b){
    this.a = a;
    this.b = b;
}
F.prototype.c = function(){};
H.prototype.c = function(){};
const instanceF = new F(1,2);
const instanceG = new G(1,2);
const instanceH = new H(1,2);
console.log(instanceF);
//->{} cの無名関数への参照なし
console.log(instanceG);
//->G{a:1, b:2}
console.log(instanceH);
//->H{a:1, b:2} cの無名関数への参照ありS

console.log('=======================');

function newOpe(C, ...args){
    const _this = Object.create(C.prototype);
//コンストラクタ関数Cのprototypeは、function(){}への参照であるcが格納
//->__proto__に、cが格納されている空オブジェクトを生成している
    console.log('1');
    console.log(_this);
    const result = C.apply(_this, args);
//第一引数 ->生成した空のオブジェクト(_this)をthisに設定して、コンストラクタ関数C実行
//第二引数以下 ->コンストラクタ関数Cを実行する時の引数を、配列で指定
    console.log('2');
    console.log(result);
    console.log('3');
    console.log(_this);
//関数の引数に、オブジェクトを渡している場合、そのオブジェクトの参照を渡していることになるので、
//C.apply(_this, args);実行時に、_this.a,_this.bにargsの値が格納されている
    console.log('4');
    console.log(args);
    if(typeof result === "object" && result !== null){
        return result;
    }
    return _this;
}
const instance = newOpe(H, 1, 2);
console.log(5);
console.log(instance);