for(let i = 0; i < 5; i++){
    const j = i * 2;
    //->constでエラーにならないので実行ごとに
    //ブロックが切り替わっている
    console.log(j);
}
for(let i = 0; i < 5; i++){
    const j = i * 2;
    setTimeout(function() {
        console.log(i);
    },1000)
}
//var j;->ブロック外に宣言しているのと同じ
for(let i = 0; i < 5; i++){
    var k = i * 2;
    setTimeout(function() {
        console.log(k);
    },1000)
    //varは、ブロックスコープをとらない
    //>forブロック外で宣伝しているのと同じ
    //ので、1秒後の実行時にはループ分の処理終えてる
}