/*
{...}
    プロパティー
        value, confiogurable, enumerable, writable,set, get
        ->ディスクリプター
value：値
configurable：設定変更可能性
enumerable：列挙可能性
writable：値の変更可能性
*/
'use strict';

const obj1 = {prop: 0}
const descriptor1 = Object.getOwnPropertyDescriptor(obj1, 'prop');
console.log(descriptor1);

const obj2 = {};
Object.defineProperty(obj2, 'prop', {
    value: 0,
    writable: true,
    configurable: true
})
//definePropertyにてプロパティーを定義したものは、
//指定しなけレバ、ディスクリプターが全てfalseになる
obj2.prop = 1;
console.log(obj2.prop);

Object.defineProperty(obj2, 'prop', {
    enumerable: true
})
delete obj2.prop;

const descriptor2 = Object.getOwnPropertyDescriptor(obj2, 'prop');
console.log(descriptor2);
