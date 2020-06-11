"use strict";
var Bok = /** @class */ (function () {
    function Bok() {
        this._name = '';
        this.code = '1234567';
    }
    Object.defineProperty(Bok.prototype, "name", {
        get: function () {
            return this._name;
        },
        set: function (name) {
            if (name === '') {
                console.log('書籍名が指定されていません');
            }
            else {
                this._name = name;
            }
        },
        enumerable: false,
        configurable: true
    });
    return Bok;
}());
var mybok = new Bok();
mybok.name = 'JavaScript入門';
console.log(mybok.name);
console.log(mybok.code);
// mybok.code = '987654'; -> mybok.codeはreadonly修飾子の為に代入不可
