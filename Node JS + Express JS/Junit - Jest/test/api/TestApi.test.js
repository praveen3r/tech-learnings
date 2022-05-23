const api = require('../../src/api/TestApi')

test('Test API', () => {
    expect.assertions(1);
    return api.fetchUsers().then(data => {
        expect(data).toHaveLength(10);
    })
})

test('Test API Async', async () => {
    expect.assertions(1);
    const data = await api.fetchUsers();
    expect(data).toHaveLength(10);
    
})