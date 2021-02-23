const items = {
	prop1: 'value1',
	prop2: 'value2',
	prop3: 'value3'
}

Object.prototype[Symbol.iterator] = function() {
	const keys = Object.keys(this);
	let i = 0;
	let _this = this;
	return {
		next() {
			let key = keys[i++];
			return {
				value: [key, _this[key]],
				done: i > keys.length
			}
		}
	}
}
//Object.prototypeに格納されているSymbolのiteratorプロパティーを
//iteratorを返す関数で定義すると、反復可能オブジェクトに変更することができる

// const items = Object.entries(obj);
//->オブジェクトを配列に変換
for (let [k, v] of items) {
	console.log(k, v);
}