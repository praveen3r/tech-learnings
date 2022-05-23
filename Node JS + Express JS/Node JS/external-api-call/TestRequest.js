const request = require('request');

request('https://jsonplaceholder.typicode.com/posts', { json: true }, (err, res, body) => {
  if (err) { return console.log(err); }
  console.log(body);
});