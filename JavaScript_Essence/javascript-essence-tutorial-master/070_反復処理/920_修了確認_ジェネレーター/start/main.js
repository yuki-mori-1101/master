/**
 * 問題：
 * 引数で与えた範囲の値をステップ毎に返却する
 * genStepというジェネレーター関数を作成しましょう。
 * 
 * - genStepの要件
 * 引数にmin, max, stepを取ります。
 * min：下限値
 * max：上限値
 * step：ステップ
 * 
 * 以下のように実行した場合には
 * const it = genStep({min: 4, max: 10, step: 2});
 * 
 * for(let value of it) {
 *   console.log(value); -> 4, 6, 8, 10
 * }
 * 
 * の値が順番にコンソールに表示されます。
 */
function* genStep({min=0, max=10, step=1} = {}) {
    for(i = min; i <= max; i += step) {
        yield i
    }
}
console.log(genStep());
const it1 = genStep({min: 4, max: 10, step: 2});
for(let value of it1) {
    console.log(value);
}
console.log('=============================================')
const it2 = genStep();
for(let value of it2) {
    console.log(value);
}
const it3 = genStep({max: 5});
for(let value of it3) {
    console.log(value);
}