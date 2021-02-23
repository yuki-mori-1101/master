/**
 * 問題：
 * 電卓の入力と同じような挙動をするチェーンメソッドを作成してみましょう。
 * 例えば、次のように使用し、結果が表示されるようにします。
  * 例１）
 * const calc = new Calculator();
  * calc.set(10)
 * .minus()
 * .set(3) -> '7'を出力(10 - 3)
  * 例２）
 * const calc = new Calculator();
  * calc.set(10)
 * 	.minus()
 * 	.set(3) -> '7'を出力
 * 	.mutiply()
 * 	.set(6) -> '42'を出力（10 - 3) * 6
 */
class Calculator {
	constructor(){
	// this.num = 0;
	// 	this.flag = 0;
	// }
	// set(num) {
	// 	if(this.flag === 0){
	// 		this.num = num;
	// 	} else if(this.flag === 1){
	// 		this.num = this.num + num;
	// 	} else if(this.flag === 2){
	// 		this.num = this.num - num;
	// 	} else if(this.flag === 3){
	// 		this.num = this.num * num;
	// 	} else if(this.flag === 4){
	// 		this.num = this.num / num;
	// 	}
	// 	console.log(this.num);
	// 	return this;
	// }
	// plus() {
	// 	this.flag = 1;
	// 	return this;
	// }
	// minus() {
	// 	this.flag = 2;
	// 	return this;
	// }
	// mutiply() {
	// 	this.flag = 3;
	// 	return this;
	// }
	// divide() {
	// 	this.flag = 4;
	// 	return this;
	// }
		this.val = null;
		this._operator; //->四則演算の式の関数を保持させる
	}
	set(val) {
		if(this.val === null) {
			this.val = val; //->newで生成した時のみ
		} else {
			this._operator(this.val , val);
		}
		return this;
	}
	plus() {
		this._operator = function(val1, val2) {
			const result = val1 + val2;
			this._equal(result);
		}
		return this;
	}
	minus() {
		this._operator = function(val1, val2) {
			const result = val1 - val2;
			this._equal(result);
		}
		return this;
	}
	mutiply() {
		this._operator = function(val1, val2) {
			const result = val1 * val2;
			this._equal(result);
		}
		return this;
	}
	divide() {
		this._operator = function(val1, val2) {
			const result = val1 / val2;
			this._equal(result);
		}
		return this;
	}
	_equal(result) {
		this.val = result;
		console.log(result);
	}
}
const calc = new Calculator();
calc.set(10)
	.minus()
	.set(3)
	.mutiply()
	.set(6)
	.divide()
	.set(2)
	.plus()
	.set(2)
