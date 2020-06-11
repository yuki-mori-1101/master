"use strict";
var Itm = /** @class */ (function () {
    function Itm(price, tax) {
        if (tax) {
            this.tax = tax;
        }
        else {
            this.tax = 10;
        }
        /*
        if(tax === undefined) {
            this.tax = 10;
        } else {
            this.tax = tax;
        }
        */
        if (isFinite(price)) {
            this.price = price;
        }
        else {
            this.price = 0;
        }
    }
    Itm.prototype.getTax = function () {
        return Math.round(this.price * (this.tax / 100));
    };
    return Itm;
}());
var appl = new Itm(180);
console.log(appl.tax);
console.log(appl.getTax());
