const addSquare = <T>(message: T): string => {
    return ('■' + message);
}

console.log(addSquare<string>('文字列を指定します'));
console.log(addSquare<number>(10));