class Itm {

    public tax: number;
    private price: number;

    constructor(price: number, tax?: number){
        if(tax) {
            this.tax = tax;
        } else {
            this.tax = 10;
        }
        /*
        if(tax === undefined) {
            this.tax = 10;
        } else {
            this.tax = tax;
        }
        */
        if(isFinite(price)){
            this.price = price;
        } else {
            this.price = 0;
        }
    }

    public getTax(): number {
        return Math.round(this.price * (this.tax / 100));
    }
}

let appl: Itm = new Itm(180);
console.log(appl.tax);
console.log(appl.getTax());