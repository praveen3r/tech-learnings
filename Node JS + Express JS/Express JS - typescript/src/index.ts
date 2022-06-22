import App from "./app";
import 'dotenv/config';

//import UserController from "./controller/UserController";
import UserRoute from "./router/UserRoute";

const app = new App(
    [new UserRoute()],
    Number(process.env.PORT)
);

app.listen();