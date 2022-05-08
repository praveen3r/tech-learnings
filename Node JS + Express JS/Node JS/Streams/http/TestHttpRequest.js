const {createServer} = require('http');
const {stat, createReadStream} = require('fs');
const {promisify} = require('util');

const fileInfo = promisify(stat);

createServer(async (req,res) => {
    console.log(`headers ${req.headers}`);
    console.log(`method ${req.method}`);
 console.log(`url ${req.url}`);
 res.end(`Hello response`);

}).listen(5050, () => console.log(`server running on port 5050`));