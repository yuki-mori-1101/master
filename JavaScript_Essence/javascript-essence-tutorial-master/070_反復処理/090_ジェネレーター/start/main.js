/*
ジェネレーター・・・
イテレーターを生成するための特殊な関数
*/

function* genIterators(max = 10){
    let i = 0;
    while(i < max){
        yield i++;
        //= done=false,value:値
    }
    return;
    //= done=true,value:値
}
const it = genIterators(10);
let a = it.next();
while(!a.done) {
    console.log(a.value);
    a = it.next();
}
console.log('============================');
for(const i of genIterators()) {
    console.log(i);
}
console.log('============================');
const obj = {
    [Symbol.iterator]: genIterators
    //[Symbol.iterator]: function* genIterator(max = 10)
    //
    //*[Symbol.iterator](max = 10){
    // let i = 0;
    //while(i < max){
    //    yield i++;
    //}
    //return;
//}
}
//Objectを反復可能オブジェクトにする
for(const i of obj) {
    console.log(i);
}