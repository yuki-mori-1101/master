/**
 * 問題１：
 * obj.prop1の値をminus関数を用いて-1したい
 * と思いました。
 * しかしminus関数実行後のobj.prop1の値は変
 * わっていませんでした。
 * 以下のminus関数をどのように修正すればobj.prop1
 * の値を変更することができるでしょうか？
 * 
 */
let obj = {
    prop1: 10
}

function minus(obj, val) {
    obj.prop1 = obj.prop1 - val;
}

minus(obj, 1);
console.log(obj.prop1);



/**
 * 問題２：
 * double関数を使ってobj.prop1の値を２倍にしたい
 * と思っていました。しかし、コンソールに表示された
 * のは元の値である'10'でした。
 * どうすれば、'20'が表示されるようになるでしょうか？
 * 
 * '20'が表示されるように、double関数内を修正してください。
 */

obj = {
    prop1: 10
}

function double(obj) {
    obj.prop1 = obj.prop1 * 2;
}

double(obj);
console.log(obj.prop1);


/**
 * 問題３：
 * 以下のコードでfn関数を実行した後にprop3の
 * 値を出力した場合に1、2、3のどれが出力
 * されるか、そして*なぜそのようになるのか*を
 * 考えてみてください。
 */
obj.prop2 = {
    prop3: 1
}

function fn({ prop2 }) { //->{prop3: 1}
    let prop = prop2; //->prop.prop3: 1
    prop.prop3 = 2; //->prop.prop3: 2 / prop2.prop3: 2 =>参照先の値が変更
    prop = { prop3: 3 }; //->prop.prop3: 3 / prop2.prop3: 2
    return { prop2: prop2 }; //->prop2.prop3: 2
}
obj = fn(obj);
console.log(obj.prop2.prop3);

/**
 * 問題４：
 * through関数を経由して格納されるobj2は
 * objと等価でしょうか？
 */
function through (obj) {
    return obj;
}

const obj2 = through(obj);
console.log(obj === obj2);
//->objもobj2もオブジェクトなので、参照先が同じであればtrue
