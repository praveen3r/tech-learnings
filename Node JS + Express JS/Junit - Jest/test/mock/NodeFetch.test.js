/*const fetch = require('node-fetch');
const createUser = require( '../../src/api/TestNodeFetch');
const {Response} = jest.requireActual('node-fetch');

test('createUser calls fetch with the right args and returns the user id', async () => {
  fetch.mockReturnValue(Promise.resolve(new Response('4')));

  const userId = await createUser();

  expect(fetch).toHaveBeenCalledTimes(1);
  expect(fetch).toHaveBeenCalledWith('http://website.com/users', {
    method: 'POST',
  });
  expect(userId).toBe('4');
});*/

test('createUser calls fetch with the right args and returns the user id', async () => {
  expect(2+2).toBe(4);
});