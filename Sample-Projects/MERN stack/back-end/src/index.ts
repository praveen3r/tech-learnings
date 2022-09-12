import App from "./app";
import 'dotenv/config';
import AuthRoute from "./router/AuthRoute";
import UserRoute from "./router/UserRoute";

const app = new App(
    [new AuthRoute(), new UserRoute()],
    Number(process.env.PORT)
);

app.listen();