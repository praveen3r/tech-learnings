const axios = require('axios');
const api = require('../../src/api/TestApi')

jest.mock('axios');

test('should fetch users', () => {
  const users = [{name: 'Bob'}];
  const resp = {data: users};
  axios.get.mockResolvedValue(resp);
  return api.fetchUsers().then(data => {
    expect(data).toEqual(users);
    expect(axios.get).toHaveBeenCalledTimes(1);
})
})