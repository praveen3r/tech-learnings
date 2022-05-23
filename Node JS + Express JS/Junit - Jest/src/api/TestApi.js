const axios = require("axios");

const api = {
  fetchUsers: () => 
    axios
      .get("https://jsonplaceholder.typicode.com/users")
      .then((response) => response.data)
      .catch((error) => "err")
  
};

module.exports = api;
