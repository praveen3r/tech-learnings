const winston = require('winston');

const { createLogger, format, transports } = require("winston");
 
const logLevels = {
  fatal: 0,
  error: 1,
  warn: 2,
  info: 3,
  debug: 4,
  trace: 5,
};
 
const logger = createLogger({
  levels: logLevels,
  format: format.combine(
    format.errors({ stack: true }),
    format.timestamp(),
    //format.colorize(),
    format.printf(({ level, message, timestamp, stack }) => {
        if (stack) {
            // print log trace 
            return `${timestamp} ${level}: ${message} - ${stack}`;
        }
        return `${timestamp} ${level}: ${message}`;
    }),
    ),
  transports: [
    new (winston.transports.Console)({ json: false, timestamp: true }),
    new winston.transports.File({ filename: 'C:/Docs/Test/debug.log', json: false, maxsize:1024, maxFiles:'10',
    zippedArchive:true })
  ],
  exceptionHandlers: [
    new (winston.transports.Console)({ json: false, timestamp: true }),
    new winston.transports.File({ filename: 'C:/Docs/Test/error.log', json: false })
  ],
  rejectionHandlers: [
    new (winston.transports.Console)({ json: false, timestamp: true }),
    new winston.transports.File({ filename: 'C:/Docs/Test/reject.log', json: false })
  ],
  exitOnError: false
});

module.exports = logger;