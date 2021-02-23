/*
演算子・・・
値(オペランド)を元に処理を行い、結果を返す記号
*/
function fn() {
    let a = 0;
    return a++;
}
console.log(fn());
console.log(!fn() * 5);
//->0はfalseなので、!によってtrueになる。
//->暗黙の型変換により、true=1とみなされる
