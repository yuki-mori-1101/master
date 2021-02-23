const a = {
    prop : 0
}

let { prop } = a;
// let { prop : x } = a; 異なる変数に分割代入をしたい場合
prop = 1;
console.log(a, prop);

function fn1 (obj){
    let { prop } = obj;
    prop = 1;
    console.log(obj, prop);
}
fn1(a);

function fn2 ({prop}){
    prop = 1;
    console.log(a, prop);
}
fn2(a);

const c = {
    prop1: {
        prop2: 0
    }
}
let { prop1 } = c; //->prop2の参照がコピーされる。参照先はc.prop1と同じ。
console.log(prop1);
prop1.prop2 = 1;
//->prop1の参照先のprop2の値が変更される=c.prop1.prop2の値が変更される。
console.log(c,prop1);
/*
分割代入したものがオブジェクトであった場合、オブジェクトの参照を保持している為に
分割元のオブジェクトにも影響がでる。
*/
