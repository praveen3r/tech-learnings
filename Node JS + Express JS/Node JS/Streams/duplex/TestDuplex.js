const {Duplex, PassThrough} = require('stream');

const {createReadStream, createWriteStream} = require('fs');

const readStream = createReadStream('../../TestFile/file1/test.txt', {encoding: 'utf8'});
const writeStream = createWriteStream('../../TestFile/file1/test12.txt', {highWaterMark: 38034});

class Throttle extends Duplex{

    constructor(time){
        super();
        this.delay = time;
    }
    _read(){

    }

    _write(chunk, encoding, callback){
        this.push(chunk);
        setTimeout(callback, this.delay);

    }

    _final(){
        this.push(null);
    }
}
const pt = new PassThrough();
const throttle = new Throttle(1000);

let total = 0;

pt.on('data', (chunk) => {
    total += chunk.length;
    console.log(`bytes: ${total}`);
})
readStream.pipe(throttle).pipe(pt).pipe(writeStream);

