const person = {
    name: 'Tom',
    // bye: () => {
    //     console.log('Bye ' + this.name);
    // },
    // ->アロー関数はthisをとらない
    bye() {
        console.log('Bye ' + this.name);
        //無名関数はthisをとる
        // = bye: function(){
    },
    hello: function (greeting) {
        console.log(greeting + ' ' + this.name);
        return greeting + ' ' + this.name;
    },
    /**
     * 問題４：
     * 1秒後に"hello Tom"
     * と出力されるような、メソッドを
     * personオブジェクトに追加してみてください。
     * 
     * 以下のように使用するものとします。
     * `person.hello1s()` 
     * -> 1秒後に"hello Tom"と出力
     * 
     * 3通りの方法で実装してみてください。
     * １．bind
     * ２．アロー関数
     * ３．thisを一旦変数に代入
     */
    hello1s(){
     //１.bind
    // setTimeout(this.hello.bind(person, 'hello'), 1000);
    // }
    //２.アロー関数
    // setTimeout(() => {
    //     this.hello('hello')
    // }, 1000)
    //３.thisを一旦変数に代入
    const _this = this;
    setTimeout(function(){
        _this.hello('hello')
    }, 1000);
    }
}
person.hello1s();
/**
 * 問題１：
 * 1秒後に"hello Tom"
 * と出力されるように、以下のコード
 * の記載を変更しましょう。
 */
// setTimeout(person.hello.bind(person, 'hello'), 1000);
// ->bindの第一引数=thisの参照先,第二引数以降=仮引数に渡される値
//setTimeoutの第一引数には関数をとる
/**
 * 問題２：
 * alertで"hello Tom"
 * と出力されるように、
 * 以下のコードを変更してください。
 */
// alert('hello Tom');
// ->alertの引数には文字列をとる
/**
 * 問題３：
 * person.byeメソッドを１秒後に実行したかったので
 * bindを使って束縛してみましたが、コンソールには
 * "Bye"しか表示されませんでした。
 * "Bye Tom"とするためにはどうすればよいでしょうか？
 */
setTimeout(person.bye.bind(person), 1000);