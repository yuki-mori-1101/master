/**
 * 問題：
 * 引数で与えた範囲の値をステップ毎に返却する
 * genStepというイテレーターを生成する関数を作成しましょう。
  * - genStepの要件
 * 引数にmin, max, stepを取ります。
 * min：下限値
 * max：上限値
 * step：ステップ
  * 以下のように実行した場合には
 * const it = genStep(4, 10, 2);
 * let a = it.next();
  * while(!a.done) {
 *  console.log(a.value); -> 4, 6, 8, 10
 *  a = it.next();
 * }
  * の値が順番にコンソールに表示されます。
 */
function genStep1(min, max, step) {
    let i = min - step;
    return {
        next: function() {
            i += step;
            if(i > max) {
                return {
                    done: true
                }
            } else {
                return {
                    done: false,
                    value: i
                }
            }
        }
    }
}
const it1 = genStep1(4, 10, 2);
let a1 = it1.next();
while(!a1.done) {
    console.log(a1.value);
    a1 = it1.next();
}

console.log('==================================================')
/**
 * 問題：
 * 引数で与えた範囲の値をステップ毎に返却する
 * genStepというジェネレーター関数を作成しましょう。
 * - genStepの要件
 * 引数にmin, max, stepを取ります。
 * min：下限値
 * max：上限値
 * step：ステップ
 * 以下のように実行した場合には
 * const it = genStep(4, 10, 2);
 * let a = it.next();
 * while(!a.done) {
 *  console.log(a.value); -> 4, 6, 8, 10
 *  a = it.next();
 * }
  * の値が順番にコンソールに表示されます。
 */
function* genStep2(min, max, step) {
    let i = min - step;
    while(i < max) {
        yield i += step;
    }
    return;
}
const it2 = genStep2(4, 10, 2);
let a2 = it2.next();
while(!a2.done) {
    console.log(a2.value);
    a2 = it2.next();
}