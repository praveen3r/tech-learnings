const {Transform} = require('stream');

class TransformText extends Transform {
    constructor(char){
        super();
        this.replaceChar = char;
    }

    _transform(chunk, encoding, callback){
          const transformChunk = chunk.toString().replace(/[a-z]|[A-Z]/g, this.replaceChar);
          this.push(transformChunk);
          callback();

    }

    _flush(callback){
        this.push('more stuff here');
        callback();
    }
}

const stream = new TransformText('A');

process.stdin.pipe(stream).pipe(process.stdout);