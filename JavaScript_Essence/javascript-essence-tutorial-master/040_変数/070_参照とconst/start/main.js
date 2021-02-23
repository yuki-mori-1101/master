// const a = 'hello';
// a = 'bye';

const b = {
    prop: 'hello'
}
// b = {}
b.prop = 'bye'; //->bへの再代入はできないがbの参照しているオブジェクトの再代入は可能
console.log(b);