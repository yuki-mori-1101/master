window.name = 'John';

const person = {
    name: 'Tom',
    hello: function() {
        console.log('Hello ' + this.name);
    }
}
person.hello();

function fn(ref){
    ref();
}
fn(person.hello);
//fnの引数に無名関数への参照のhelloが渡されるのみなのでthisはグローバルオブジェクト
