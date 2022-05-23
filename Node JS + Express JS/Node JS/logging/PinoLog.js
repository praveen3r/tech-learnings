const pino = require('pino');

/*const transport = pino.transport({
    target: './PinoTransport.mjs',
  options: { destination: 'C:/Docs/Test/debug.log' }
  })*/

  const transport = pino.transport({targets: [
    { target: './PinoTransport.mjs', level: 'info' , options: { destination: 'C:/Docs/Test/debug.log' }},
    { target: './PinoTransport.mjs', level: 'error' , options: { destination: 'C:/Docs/Test/error.log' }},
  ]});

// Create a logging instance
const logger = pino({
level: process.env.NODE_ENV === 'production' ? 'info' : 'debug',
}, transport);


module.exports = logger;