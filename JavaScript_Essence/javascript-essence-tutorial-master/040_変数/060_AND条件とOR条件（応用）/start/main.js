function hello(name){
    if(!name){
        name = 'Tom'
    }
    console.log('Hello' + name);
}
hello()

function hell(name = 'Bob'){
    // name = name || 'Bob' -> nameにfalsyな値(例:0)が入るとBobになる
    console.log('Hell' + name);
}
hell()

let nam = 'Michell'
// if(nam){
//     hell(nam);
// }
nam && hell(nam);
// namがtrusyな値でアあれば&&以降の処理が実行される