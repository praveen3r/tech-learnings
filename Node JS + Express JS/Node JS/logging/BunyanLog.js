const bunyan = require("bunyan");

const logger = bunyan.createLogger({
  name: "myapp",
  streams: [
    {
      level: "info",
      path: 'C:/Docs/Test/debug.log', // log INFO and above to stdout
    },
    {
      level: "error",
      path: 'C:/Docs/Test/error.log', // log ERROR and above to a file
    },
  ],
});

module.exports = logger;
