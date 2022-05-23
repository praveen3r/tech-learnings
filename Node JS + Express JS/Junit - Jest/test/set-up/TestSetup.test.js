/* beforeEach(() => initDatabase());
afterEach(() => closeDatabase()); 

beforeAll(() => initDatabase());
afterAll(() => closeDatabase()); */

const initDatabase = () => console.log(`Setup database`);
const closeDatabase = () => console.log(`close database`);

test('Test before', () => {
    expect(1 + 1).toEqual(2);
});

test('Test after', () => {
    expect(2 + 2).toEqual(4);
});

describe('Test block', () => {
    beforeEach(() => initDatabase());

    test('Test after', () => {
        expect(2 + 2).toEqual(4);
    });

    test('Test after', () => {
        expect(2 + 2).toEqual(4);
    });
})