{
    var a = 0;
}
console.log(a); //ブロックの中で変数を宣言してもvarであればブロック外からも参照可

console.log(b); //letの変数は宣言されてから使用しないと「UncaguhtError」
console.log(c); //varの変数は宣言される前に使用できるが、Undfinedになる
let b = 0;
var c = 0;