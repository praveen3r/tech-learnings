const {createReadStream, createWriteStream} = require('fs');

const readStream = createReadStream('../../TestFile/file1/test.txt', {encoding: 'utf8'});
const writeStream = createWriteStream('../../TestFile/file1/test12.txt', {highWaterMark: 38034});

readStream.on('data', (result) => {
     const result = writeStream.write(result);
     if(!result){
         console.log(`back pressure`);
         readStream.pause();
     }
});

readStream.on('end', (result) => {
    writeStream.end();
});

readStream.on('error', (err) => {
    console.log(`end of stream ${err}`);
});

writeStream.on('drain', (result) => {
    console.log('drained');
    readStream.resume();
})
writeStream.on('close', (result) => {
    console.log(`file copied`);
})