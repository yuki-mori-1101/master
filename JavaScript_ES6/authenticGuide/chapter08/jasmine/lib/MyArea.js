"use strict";

// コンストラクター(base/heightプロパティの定義)
var MyArea = function MyArea(base, height) {
    this.base = base;
    this.height = height;
};

/** 
 * getTriangle/getSquareメソッドを定義
 * @constructor
 * @return {int} 計算結果
 */
MyArea.prototype = {
    getTriangle: function getTriangle() {
        return this.base * this.height / 2;
    },
    getSquare: function getSquare() {
        return this.base * this.height;
    }
};
