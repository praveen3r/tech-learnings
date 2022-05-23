const axios = require('axios');

/* axios.get('https://jsonplaceholder.typicode.com/posts')
  .then(response => {
    console.log(response.data);
  })
  .catch(error => {
    console.log(error);
  });*/

  axios.all([
    axios.get('https://jsonplaceholder.typicode.com/posts'),
    axios.get('https://jsonplaceholder.typicode.com/users')
  ]).then(axios.spread((response1, response2) => {
    console.log(response1.data);
    console.log(response2.data);
  })).catch(error => {
    console.log(error);
  });