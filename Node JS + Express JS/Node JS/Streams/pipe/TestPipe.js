const {createReadStream, createWriteStream} = require('fs');

const readStream = createReadStream('../../TestFile/file1/test.txt', {encoding: 'utf8'});
const writeStream = createWriteStream('../../TestFile/file1/test12.txt', {highWaterMark: 38034});

// readStream.pipe(writeStream).on('error', (error) => {
//     console.log(error);
// })

process.stdin.pipe(writeStream);