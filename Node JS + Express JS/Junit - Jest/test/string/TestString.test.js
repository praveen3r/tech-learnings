const reverseString = require('../../src/string/TestString');

test('Test String', () => {
    expect(reverseString('test')).toEqual('tset');
});