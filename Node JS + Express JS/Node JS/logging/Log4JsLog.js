const log4js = require("log4js");

//var logger = log4js.getLogger();
//logger.level = "debug";

log4js.configure({
    appenders: { cheese: { type: "file", filename: "C:/Docs/Test/debug.log" } },
    categories: { default: { appenders: ["cheese"], level: "error" } }
  });
  
  //const logger = log4js.getLogger("cheese");

  const logger = log4js.getLogger();
logger.level = "debug";

module.exports = logger;