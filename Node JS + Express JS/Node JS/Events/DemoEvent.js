const EventEmitter = require('events')

const customEmitter = new EventEmitter();

customEmitter.on('test', (name) => {
    console.log(`data received ${name} `);
})

customEmitter.emit('test', 'Sachin');

