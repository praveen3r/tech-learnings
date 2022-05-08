const {createServer} = require('http');
const {stat, createReadStream} = require('fs');
const {promisify} = require('util');

const fileInfo = promisify(stat);

createServer(async (req,res) => {
    const {size} = await fileInfo('../../TestFile/file1/test.txt');
    res.writeHead(200, {
        'Content-length': size,
        'Content-Type': 'application/json'
    })

    createReadStream('../../TestFile/file1/test.txt').pipe(res);

}).listen(5050, () => console.log(`server running on port 5050`));