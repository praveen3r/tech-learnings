const functions = {
    add: (num1, num2) => num1 + num2,
    isNull: () =>  null,
    isFalsy: x => x,
    checkObj: () => {
        const comp = {id: 1, name: 'test'}
        return comp;
    },
    throwError: () => {
        throw new Error('Error occured');
    }
}

module.exports = functions;