/*
オブジェクトのメソッドとして、実行される場合は、
　'this' => 呼出元のオブジェクトを参照
関数として、実行される場合は、
　'this' => グローバルオブジェクトを参照
*/
window.name = 'John';
const person = {
    name: 'Tom',
    //hello: () => {
//アロー関数の場合はthisやargumentsをとらない。グローバルオブジェクトを参照
    hello(){
//ES6から↑は、helloプロパティに無名関数が格納される(=hello:function())
        console.log('Hello ' + this.name);
        a();
    }
}
const a = () => console.log('Bye ' + this.name);
person.hello();

function b(){
    const a = () => console.log('Bye ' + this.name);
    a();
}
b();