import winston, { createLogger, transports, format } from "winston";
import "dotenv/config";

class LogManager {
  private static instance: winston.Logger;

  private constructor() {}

  public static getInstance(): winston.Logger {
    if (!LogManager.instance) {
      const logLevels = {
        fatal: 0,
        error: 1,
        warn: 2,
        info: 3,
        debug: 4,
        trace: 5,
      };

      LogManager.instance = createLogger({
        levels: logLevels,
        level: process.env.LOG_LEVEL,
        format: format.combine(
          format(info => ({ ...info, level: info.level.toUpperCase() }))(),
          format.errors({ stack: true }),
          format.splat(),
          format.timestamp({format: 'YYYY-MM-DD HH:mm:ss'}),
          format.colorize(),
          format.printf(({ level, message, timestamp, stack }) => {
            const levelUpper = level.toUpperCase();
            if (stack) {
              // print log trace
              return `${timestamp} ${level}: ${message} - ${stack}`;
            }
            return `${timestamp} ${level}: ${message}`;
          })
        ),
        transports: [
          new winston.transports.Console(),
          new winston.transports.File({
            dirname: process.env.LOG_DIR,
            filename: "debug.log",
            maxsize: +(process.env.LOG_MAX_FILE_SIZE!),
            maxFiles: +(process.env.LOG_MAX_FILES!),
            //zippedArchive: true,
            options: {
              json: false,
            },
          }),
        ],
        exceptionHandlers: [
          new winston.transports.Console(),
          new winston.transports.File({
            dirname: process.env.LOG_DIR,
            filename: "error.log",
            maxsize: +(process.env.LOG_MAX_FILE_SIZE!),
            maxFiles: +(process.env.LOG_MAX_FILES!),
            //zippedArchive: true,
            options: {
              json: false,
            },
          }),
        ],
        rejectionHandlers: [
          new winston.transports.Console(),
          new winston.transports.File({
            dirname: process.env.LOG_DIR,
            filename: "reject.log",
            maxsize: +(process.env.LOG_MAX_FILE_SIZE!),
            maxFiles: +(process.env.LOG_MAX_FILES!),
            //zippedArchive: true,
            options: {
              json: false,
            },
          }),
        ],
        exitOnError: false,
      });
    }
    return LogManager.instance;
  }
}

export default LogManager;
