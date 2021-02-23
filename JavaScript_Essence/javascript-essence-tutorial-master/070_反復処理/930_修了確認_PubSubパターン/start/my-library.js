/**
 * 問題：
 * MyLibraryという汎用的な使用を想定したライブラリのクラス
 * を作成したいとします。
 * 第3者に使用されることを想定しているため、このクラスを
 * 初期化した際（new MyLibrary()）にコンストラクター内で
 * ユーザーが何らかの独自の関数を実行できる仕組みを設けたい
 * と思いました。
 * そこで以下のように動作するeventsというオブジェクトを
 * 一つ作成する事にしました。
 * どのようにしてeventsオブジェクトを実装すれば良いか
 * 考えてみてください。
 * eventsオブジェクトはon、off、emitのメソッドを持っています。
  *********************************** 
  * １．onの第一引数で実行場所、第二引数で実行したい関数を登録します。
 * events.on('beforeInit', customFn1);
 * events.on('beforeInit', customFn2);
 * events.on('afterInit', customFn3);
  *********************************** 
  * ２．offで"on"と同じ実引数を渡すことで、onで登録した関数を解除できます。
  ***********************************
  * ３．emitでonで登録した関数をすべて実行します。
 * （１）のように登録されていた場合には、new MyLibrary()
 * とすると以下の内容がコンソールに表示されるものとします。
  * customFn1
 * customFn2
 * library process
 * customFn3
  */
 //即時関数で以下宣言時に以下のオブジェクトを使用できるようにする
const events = (function() {
	//外部から以下変数を触れないようにする為に即時関数の中で宣言する
	const eventStack = new Map();
	//戻り値として以下関数をもっているオブジェクトを定義
	return {
		//Publisher
		on(key, fn) {
			//1つのkeyに複数valueが登録される可能性がある為にvalueをSetに格納
			const fnStack = eventStack.get(key) || new Set();
			//既にMapに同keyにvalueが登録されている場合の考慮
			fnStack.add(fn);
			eventStack.set(key, fnStack);
		},
		off(key, fn) {
			const fnStack = eventStack.get(key);
			if(fnStack && fnStack.has(fn)) {
				fnStack.delete(fn);
			}
		},
		//Subscriber
		emit(key) {
		//emit(key, _this) {
		//実行クラスのコンテキストも渡すことができる
			const fnStack = eventStack.get(key);
			if(fnStack) {
				//fnStackに1以上のvalueが登録されている場合以下実行
				for(const fn of fnStack) {
					fn();
					//fn.call(_this);
					//実行クラスのコンテキストも渡すことができる
				}
			}
		}
	}
})();

class MyLibrary {
	constructor() {
		events.emit('beforeInit');
		//events.emit('beforeInit', this);
		//->MyLibraryのコンテキストも渡すことができる
		console.log('library process');
		
		events.emit('afterInit');
	}
	method() {
		// do something
	}
}
