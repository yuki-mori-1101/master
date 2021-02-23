let a = 'hello';
let b = a;
b = 'bye'; //プリミティブ値のコピー->参照先の値がコピーされる
console.log(a,b);

let c = {
    prop: 'bye'
}
let d = c;
console.log(c,d);　// オブジェクトのコピー->オブジェクトへの参照がコピーされる
d = {}; // オブジェクトの再代入
console.log(c,d);