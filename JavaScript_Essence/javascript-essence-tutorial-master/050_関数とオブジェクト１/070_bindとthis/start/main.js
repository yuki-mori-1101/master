/*
bindによって'this'や引数を固定した新しい関数を作成。
 ->bindによるthisの束縛
*/

window.name = 'John';

const person = {
    name: 'Tom',
    hello: function() {
        console.log('Hello ' + this.name);
    }
}
person.hello(); //->thisは呼出元のname

function fn(ref) {
    ref();
}

fn(person.hello); //->thisはグローバルオブジェクトのname

const helloTom = person.hello.bind(person);
//bindの引数であるオブジェクトを、helloで実行されるthisの参照先として設定
//参照のコピーでなく、新たな別の関数としてメモリ空間に格納される
fn(helloTom);

function a(){
    console.log('hello ' + this.name);
}
const b = a.bind({name: 'Tim'});
b();

function c(name){
    console.log('hello ' + name);
}
const d = c.bind(null, 'Michell');
// bindの第一引数->thisの参照先、第二引数->引数の値
d('Oliver');
// ->bindで渡した引数の方が優先される