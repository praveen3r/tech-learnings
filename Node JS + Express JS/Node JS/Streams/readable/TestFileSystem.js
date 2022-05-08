const fs = require('fs');

const stream = fs.createReadStream('../../TestFile/file1/test.txt', {encoding: 'utf8'});

stream.on('data', (result) => {
    console.log(`data ${result}`);
});

stream.on('end', (result) => {
    console.log(`end of stream ${result}`);
});

stream.on('error', (err) => {
    console.log(`end of stream ${err}`);
});

//stream.pause();

//stream.resume();

/* process.stdin.on('data', (result) => {
    let chunk = result.toString().trim();
    console.log(chunk);
});*/