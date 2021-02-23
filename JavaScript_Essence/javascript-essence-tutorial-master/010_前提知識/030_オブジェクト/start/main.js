let obj = {
    prop1: 'value1',
    prop2: 'value2',
    prop3: function(){
        // メソッド
        console.log('value3');
    },
    prop4: {
        prop5: 'value5'
    }
}

console.log(obj.prop1);
console.log(obj.prop2);
obj.prop3();
console.log(obj.prop4);
console.log(obj.prop4.prop5);

obj.prop6 = 'value6';
console.log(obj.prop6);
console.log(obj);

