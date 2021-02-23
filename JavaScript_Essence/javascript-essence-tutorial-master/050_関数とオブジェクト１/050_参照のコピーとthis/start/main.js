window.name = 'John';

const person = {
    name: 'Tom',
    hello: function() {
        console.log('Hello ' + this.name);
        a();
    }
}
person.hello();
const ref = person.hello;
//->personオブジェクトの、helloオブジェクト(無名関数への参照)をrefにコピー
ref();
//->refオブジェクト(無名関数への参照)の実行なので、this参照はグローバルオブジェクト

person.hello();
function a(){
    console.log('Hello' + this.name);
}