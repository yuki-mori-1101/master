class Bok {
    private _name: string = '';
    readonly code: string = '1234567';

    set name(name: string) {
        if(name === '') {
            console.log('書籍名が指定されていません');
        } else {
            this._name = name;
        }
    }

    get name(): string {
        return this._name;
    }
}

let mybok: Bok = new Bok();
mybok.name = 'JavaScript入門';
console.log(mybok.name);
console.log(mybok.code);
// mybok.code = '987654'; -> mybok.codeはreadonly修飾子の為に代入不可