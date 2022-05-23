jest.mock('../../src/mock/TestMock'); // this happens automatically with automocking
const foo = require('../../src/mock/TestMock');

// foo is a mock function
foo.mockImplementation(() => 'overriding mock');

//multiple function calls produce different results
foo.mockImplementationOnce(() => 'overriding mock')
.mockImplementationOnce(() => 'overriding mock123');


// The first argument of the first call to the function was 0
test('mockCallback', () => {
    console.log(foo());
    console.log(foo());
    expect(1 + 1).toBe(2);
    });