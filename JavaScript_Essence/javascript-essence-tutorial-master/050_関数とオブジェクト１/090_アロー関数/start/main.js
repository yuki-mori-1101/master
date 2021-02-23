/*
アロー関数->無名関数を記述しやすくした省略法
*/
function a(name){
    return 'hello ' + name;
}

const b = function(name) {
    return 'hello ' + name;
}

const c = name => {
    return 'hello ' + name;
}
// 引数が1つの場合は、()を省略できる

const d = name => 'hello ' + name;
// 式が1つの場合は、{}とreturnが省略できる  
console.log(d('Tom'));

const e = (name1, name2) => 'hello ' + name1 +' '+ name2;
console.log(e('Tom', 'Bob'));

const f = () => 'hello Michell';
console.log(f());
const g = _ => 'hello Oliver';
console.log(g());