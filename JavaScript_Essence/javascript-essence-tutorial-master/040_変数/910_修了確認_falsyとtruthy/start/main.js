/**
 * 問題１：
 * 以下のコンソールにはどのような値が表示されるでしょうか？
 */
console.log("問題１")
console.log("0 == false", 0 == false)
// ->0 == false true
// 抽象的な等価性である為に、0がfalseに変換される
console.log("0 === false", 0 === false);
// ->0 === false false
// 厳格な等価性である為に、0はfalseに変換されない、型まで考慮される
console.log('"false" == false', "false" == false);
// -->"false" == false false
// 抽象的な等価性である為に、文字列はtrusyな値になる(""の場合を除く)
console.log('"0" == 0', "0" == 0);
// ->"0" == 0' true
// 抽象的な等価性である為に、stringからintへの暗黙的な型変換がされる
console.log('Boolean("0") === false', Boolean("0") === false);
// -->Boolean("0") === false false
// Boolean(文字列)は、trueが戻り値になる(""の場合を除く)
console.log('Boolean(0) === false', Boolean(0) === false);
// ->'!Boolean(0) === false' true
// Boolean(0)は、falseが戻り値になる。Boolean(0以外)は、trueが戻り値になる。
console.log('!Boolean(0) === false', !Boolean(0) === false);
// -->'!Boolean(0) === false' false
// Boolean(0)は、falseが戻り値になる。Boolean(0以外)は、trueが戻り値になる。
console.log('-1 == false', -1 == false);
// ->'-1 == false' false
// 数値でfalseになるのは、0のみ。
console.log('!10 === false', !10 === false);
// -->'!10 === false' true

/**
 * 問題２：
 * 関数fnの引数numが渡ってこない場合（undefinedまたはnullの場合）のみ、
 * 初期値として-1を設定したいものとします。
 * 
 * 以下の関数fnの初期化を適切に書き直してください。
 * ※aには0以上の整数値が渡ってくるものとします。
 */
// let a = 1;
console.log("問題２")
let a;
let b = null;
let c = 0;
// function fn(num = -1){
// ->デフォルト値は、undefinedの場合にのみ実行される。
// 今回の問題では、nullをnumに代入されると-1の値が代入されない。
function fn(num) {
    // num = num || -1;
    // ->数値の場合、num=0であれば、falsyな値になるので||以降が実行される。
    if(num === undefined || num === null){
        num = -1;
    }
    console.log(num);
}
fn(a);
fn(b);
fn(c);


/**
 * 問題３：
 * 以下のコードを実行した際にコンソールに
 * 期待の出力を行うような関数greetingを
 * 作成してみてください。
 *
 * greeting("Bob", "hi"); -> 出力結果："hi, Bob"
 * greeting("Bob"); -> 出力結果："hello, Bob"
 *
 */
console.log("問題３")
function greeting(arg1, arg2){
    arg2 = arg2 || 'hello';
    // ->文字列の場合、""であればfalsyな値になる。
    // if(arg2 == null){
    //     arg2 = 'hello'
    // }
    // console.log(arg2 + ',' + arg1);
    console.log(`${arg2}, ${arg1}`);
}
greeting("Bob", "hi");
greeting("Bob");
greeting("Bob", "");


