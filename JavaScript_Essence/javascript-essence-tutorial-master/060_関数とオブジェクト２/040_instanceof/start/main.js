/*
instanceof・・・どのコンストラクターから生成されたオブジェクトかを確認する。
*/
function F(a, b) {
    this.a = a;
    this.b = b;
    // return {a: 1};
}
F.prototype.c = function() {}
const instanceF = new F(1, 2);
console.log(instanceF instanceof F);
console.log(instanceF.__proto__ === F.prototype);
console.log(instanceF);
console.log(instanceF.__proto__);
console.log(F);
console.log(F.prototype);

function G(a, b) {
    this.a = a;
    this.b = b;
    return {a: 1};
}
G.prototype.c = function() {}
const instanceG = new G(1, 2);
console.log(instanceG instanceof G);
console.log(instanceG.__proto__ === G.prototype);
console.log(instanceG instanceof Object);
console.log(instanceG.__proto__ === Object.prototype);
console.log(instanceG);
console.log(instanceG.__proto__);
console.log(G);
console.log(G.prototype);
console.log(instanceF)


function fn(arg){
    //渡される引数の型によって処理を分ける
    if(arg instanceof Array){
        arg.push('value');
    } else {
        arg['key'] = 'value';
    }
    console.log(arg);
}
fn({});
fn([]);