//実行コンテキストによってthisの参照先は変わる
//呼出元のオブジェクトへの参照を保持する
const person = {
    name: 'Tom',
    hello: function() {
        console.log('Hello' + this.name);
    }
}
person.hello();