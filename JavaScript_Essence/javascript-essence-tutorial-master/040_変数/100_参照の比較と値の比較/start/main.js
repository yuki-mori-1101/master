const a = {
    prop: 0
}

const b = {
    prop: 0
}

console.log(a === b);
//->参照先のオブジェクトが同一であるか
const c = a;
console.log(a === c);

console.log(a.prop === b.prop);
//->参照先のオブジェクトの値が同一であるか

/*
プリミティブ型では値の比較
オブジェクトは参照の比較
*/