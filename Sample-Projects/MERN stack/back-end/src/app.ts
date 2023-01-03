import express, { Application } from "express";
import cors from "cors";
import errorMiddleWare from "./middleware/ErrorMiddleware";
import AppRouter from "./router/AppRouter";
import mongoose, { ConnectOptions } from "mongoose";
import "dotenv/config";
import authMiddleware from "./middleware/AuthMiddleware";
import { StatusCodes } from "http-status-codes";
import { HTTPErrors } from "./model/HTTPErrors";
import methodNotAllowedMiddleWare from "./middleware/MethodNotAllowedMiddleware";
import LogManager from "./log/LogManager";
import { LoggerLevel } from "mongodb";

class App {
  private express: Application;
  private port: number;
  private log = LogManager.getInstance();

  constructor(routes: AppRouter[], port: number) {
    this.express = express();
    this.port = port;
    this.initializeDatabase();
    this.initializeMiddleware();
    this.initializeRoutes(routes);
    this.initialiseErrorHandling();
  }

  private initializeMiddleware(): void {
    this.express.use(cors());
    this.express.use(express.json());
    this.express.use(authMiddleware);
  }

  private initializeRoutes(routes: AppRouter[]): void {
    routes.forEach((route: AppRouter) => {
      this.express.use("/api", route.router);
    });
    routes.forEach((route: AppRouter) => {
      this.express.all('*', methodNotAllowedMiddleWare);
    });
    this.express.all('*', (req, res) => {
      res.status(StatusCodes.NOT_FOUND).send(HTTPErrors.NOT_FOUND);
    });
  }

  private initialiseErrorHandling(): void {
    this.express.use(errorMiddleWare);
  }

  initializeDatabase(): void {
   
    try {
      const options: ConnectOptions = {
        autoIndex: false, // Don't build indexes
        maxPoolSize: +(process.env.CONNECTION_POOL_MAX_SIZE!), // Maintain up to 10 socket connections
        serverSelectionTimeoutMS: +(process.env.CONNECTION_POOL_IDLE_TIMEOUT!), // Keep trying to send operations for 5 seconds
        socketTimeoutMS: +(process.env.CONNECTION_POOL_SOCKET_TIMEOUT!), // Close sockets after 45 seconds of inactivity
        family: 4, // Use IPv4, skip trying IPv6,
        connectTimeoutMS: +(process.env.CONNECTION_POOL_TIMEOUT!),
        loggerLevel: LoggerLevel.DEBUG,
      };
      mongoose.connect(process.env.MONGO_URI!, options, () => {
        this.log.info(`connected to mongo db`);
      });
      mongoose.connection.on("error", function () {
        const log = LogManager.getInstance();
        
        log.error(
          "MongoDB Connection Error. Make sure MongoDB is running."
        );
      });
      mongoose.set("debug", true); //debug queries
      
    } catch (error) {
      this.log.error(`error is ${error}`);
      process.exit(1);
    }
  }

  public listen(): void {
    this.express.listen(this.port, () => {
      this.log.debug(`App listening on the port ${this.port}`);
    });
  }
}

export default App;
