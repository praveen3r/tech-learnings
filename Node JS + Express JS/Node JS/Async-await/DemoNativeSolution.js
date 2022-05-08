const { readFile, writeFile } = require('fs')
const util = require('util')

const readFilePromise = util.promisify(readFile);

const start = async () => {
    try {
        const first = await readFilePromise('../TestFile/file1/test.txt', {encoding: 'utf8'});
        const second = await readFilePromise('../TestFile/file1/test-async.txt', {encoding: 'utf8'});
        console.log(first);
        console.log(second);
    }
    catch (error) {
        console.error(error);
    }
}

start();
