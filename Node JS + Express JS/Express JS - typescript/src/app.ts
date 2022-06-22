import express, { Application } from "express";
//import userRouter from './router/UserRoute';
import loggerMiddleWare from "./middleware/DemoMiddleware";
import cors from "cors";
import Controller from "./controller/Controller";
import errorMiddleWare from "./middleware/ErrorMiddleware";
import AppRouter from "./router/AppRouter";
import mongoose, { ConnectOptions } from "mongoose";
import "dotenv/config";

/*const app = express();

app.use(loggerMiddleWare);

app.use("/user", userRouter);

app.listen(5000);*/

class App {
  private express: Application;
  private port: number;

  /*constructor(controllers: Controller[], port: number) {
        this.express = express();
        this.port = port;
        this.initializeMiddleware();
        this.initializeControllers(controllers);
        this.initialiseErrorHandling();

    }*/

  constructor(routes: AppRouter[], port: number) {
    this.express = express();
    this.port = port;
    this.initializeDatabase();
    this.initializeMiddleware();
    this.initializeRoutes(routes);
    this.initialiseErrorHandling();
  }

  private initializeMiddleware(): void {
    //this.express.use(helmet());
    //this.express.use(morgan('dev'));
    //this.express.use(compression())
    this.express.use(cors());
    this.express.use(express.json());
    this.express.use(loggerMiddleWare);
  }

  /*private initializeControllers(controllers: Controller[]): void{
        controllers.forEach((controller: Controller) => {
            this.express.use('/api', controller.router);
        });
    }*/

  private initializeRoutes(routes: AppRouter[]): void {
    routes.forEach((route: AppRouter) => {
      this.express.use("/api", route.router);
    });
  }

  private initialiseErrorHandling(): void {
    this.express.use(errorMiddleWare);
  }

  initializeDatabase(): void {
    /*const { MONGO_USER, MONGO_PASSWORD, MONGO_PATH } = process.env;

        mongoose.connect(
            `mongodb://${MONGO_USER}:${MONGO_PASSWORD}${MONGO_PATH}`
        );*/
    try {
      const options: ConnectOptions = {
        autoIndex: false, // Don't build indexes
        maxPoolSize: 10, // Maintain up to 10 socket connections
        serverSelectionTimeoutMS: 5000, // Keep trying to send operations for 5 seconds
        socketTimeoutMS: 45000, // Close sockets after 45 seconds of inactivity
        family: 4, // Use IPv4, skip trying IPv6,
        connectTimeoutMS: 5000,
        loggerLevel: "debug",
      };
      //this.initializeConnectionPoolMonitoring();
      mongoose.connect(process.env.MONGO_URI!, options, () => {
        console.log(`connected to mongo db`);
      });
      mongoose.connection.on("error", function () {
        console.error(
          "MongoDB Connection Error. Make sure MongoDB is running."
        );
      });
      mongoose.set("debug", true); //debug queries
      
    } catch (error) {
      console.log(`error is ${error}`);
      process.exit(1);
    }
  }

  private initializeConnectionPoolMonitoring(): void {
    mongoose.connection.getClient().on("connectionPoolCreated", (event) => console.log(event));
    mongoose.connection.getClient().on("connectionPoolClosed", (event) => console.log(event));
    mongoose.connection.getClient().on("connectionCreated", (event) => console.log(event));
    mongoose.connection.getClient().on("connectionReady", (event) => console.log(event));
    mongoose.connection.getClient().on("connectionClosed", (event) => console.log(event));
    mongoose.connection.getClient().on("connectionCheckOutStarted", (event) => console.log(event));
    mongoose.connection.getClient().on("connectionCheckOutFailed", (event) => console.log(event));
    mongoose.connection.getClient().on("connectionCheckedOut", (event) => console.log(event));
    mongoose.connection.getClient().on("connectionCheckedIn", (event) => console.log(event));
    mongoose.connection.getClient().on("connectionPoolCleared", (event) => console.log(event));
    mongoose.connection.getClient().on('serverDescriptionChanged', (event) => console.log(JSON.stringify(event, null, 2)));
    mongoose.connection.getClient().on('serverHeartbeatStarted', (event) => console.log(JSON.stringify(event, null, 2)));
    mongoose.connection.getClient().on('serverHeartbeatSucceeded', (event) => console.log(JSON.stringify(event, null, 2)));
    mongoose.connection.getClient().on('serverHeartbeatFailed', (event) => console.log(JSON.stringify(event, null, 2)));
    mongoose.connection.getClient().on('serverOpening', (event) => console.log(JSON.stringify(event, null, 2)));
    mongoose.connection.getClient().on('serverClosed', (event) => console.log(JSON.stringify(event, null, 2)));
    mongoose.connection.getClient().on('topologyOpening', (event) => console.log(JSON.stringify(event, null, 2)));
    mongoose.connection.getClient().on('topologyClosed', (event) => console.log(JSON.stringify(event, null, 2)));
    mongoose.connection.getClient().on('topologyDescriptionChanged', (event) => console.log(JSON.stringify(event, null, 2)));
  
  }

  public listen(): void {
    this.express.listen(this.port, () => {
      console.log(`App listening on the port ${this.port}`);
    });
  }
}

export default App;
