let a = 2;
window.a = 4;
function fn1() {
    // let a = 1;
    function fn2() {
        console.log(a);
        if (true) {
            var a = 3;
            // 8行目がvar宣言であるとブロックスコープでなくなるので6行はUndifined出力
            // 8行目がconst,let宣言であるとスクリプトスコープの2が出力
            // 　　　　　　　　　スクリプトスコープはグローバルスコープの内側に存在する
        }

    }
    fn2();
}
fn1();



