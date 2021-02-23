/*
for ..in・・・
列挙可能プロパティーに対して順不同で反復処理を実行
プロトタイプチェーンも列挙対象となる(Symbolで定義したプロパティーは対象外)
->自分自身に列挙されているプロパティーのみを
  列挙したい場合は、Object.hasOwnProperty
*/
const s = Symbol();
const obj = {
	prop1: 'value1',
	prop2: 'value2',
	prop3: 'value3',
	[s]: 'value4' //->変数をプロパティーの値に格納する場合は[]を使用する
}
Object.prototype.method = function(){}
Object.defineProperty(
	obj,
	'prop1',
	{enumerable: false}
);
const d = Object.getOwnPropertyDescriptor(
	Object.prototype,
	'method'
)
console.log(d);
const e = Object.getOwnPropertyDescriptor(
	obj,
	s
)
console.log(e);

for(let key in obj) {
	// if(obj.hasOwnProperty(key)){
		console.log(key, obj[key]);
	// }
}