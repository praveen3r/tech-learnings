const { Readable } = require('stream');

class StreamFromArray extends Readable {

    constructor(array) {
        super({encoding: 'utf8'}); //encoding converts stream into string
        //super({objectMode: true}); //encoding converts stream into json
        this.array = array;
        this.index = 0;
    }

    _read() {
        if (this.index <= this.array.length) {
            const data = this.array[this.index];
            this.push(data);
            this.index++;
        }
    }
}

const dataArr = ['1', '2', '3', '4', '5', '6'];

const customStream = new StreamFromArray(dataArr);

customStream.on('data', (result) => {
    console.log(result);
});

customStream.on('end', (result) => {
    console.log(result);
});