const functions = require('../../src/basics/Basic')

test.concurrent('Testing Add function', async () => {
    expect(functions.add(1,2)).toBe(3);
});

test.concurrent('Testing Add function Not', async () => {
    expect(functions.add(1,2)).not.toBe(4);
});

test.concurrent('Testing function null', async () => {
    expect(functions.isNull()).toBeNull();
});

test.concurrent('Testing function falsify', async () => {
    expect(functions.isFalsy()).toBeFalsy();
});

test.concurrent('Testing function objects', async () => {
    expect(functions.checkObj()).toEqual({
        id: 1,
        name: 'test'
    });
});

test.concurrent('Testing matches', async () => {
    const input1 = 400;
    const input2 = 400;

    expect(input1 + input2).toBeLessThan(1500);
});

test.concurrent('Test regex', async () => {
    expect('Team').not.toMatch(/U/);
})

test.concurrent('Test Arrays', async () => {
    const names = ['Test1', 'Test2', 'Test3'];
    expect(names).toContain('Test1');
})

test.concurrent('Test Arrays length', async () => {
    const names = ['Test1', 'Test2', 'Test3'];
    expect(names).toHaveLength(3);
})

test.concurrent('Test Arrays length Comparison', async () => {
    const names = ['Test1', 'Test2', 'Test3'];
    expect(names.length).toBeLessThan(5);
})

test.concurrent('Throwing error', async () => {
    expect(functions.throwError).toThrowError();
})