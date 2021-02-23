function printEquality(a,b){
    console.log(a === b); //厳格な透過性
    console.log(a == b); //抽象な透過性
}

let a = '1';
let b = 1;

printEquality(a,b)

let c = true;

printEquality(b,c);

console.log(c === Boolean(b));

console.log(Boolean(0));

let d = "";
let e = 0;
let f = "0";
let g = "1";

console.log(Boolean(d)); //→false
console.log(Boolean(e)); //→false
console.log(Boolean(f)); //→true
console.log(Boolean(g)); //→true
// Booleanは空文字→false, 値有り→true
// Booleanは0→false, 0以外→true

printEquality(d,e); //→false,true
printEquality(Boolean(d),e); //→false,true
printEquality(Boolean(d),Boolean(e)); //→true,true
// 空文字はparseIntで数値に変換できないので、Booleanで変換してから比較する必要

let h = null;
let i;
printEquality(h,i);
