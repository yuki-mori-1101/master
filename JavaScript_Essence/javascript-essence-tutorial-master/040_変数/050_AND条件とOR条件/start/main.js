const a = 0;
const b = 1;
const c = 2;
const d = 3;
console.log(a && b);
// aがfalsyな値であれば、aの値を戻り値とする
console.log(b && c);
// bがtrusyな値であれば、cの値を戻り値とする
console.log(b && c && d);
// a,bがtrusyな値であれば、cの値を戻り値とする

console.log(a || b);
// aがfalsyな値であれば、bの値を戻り値とする
console.log(b || c);
// bがtrusyな値であれば、bの値を戻り値とする