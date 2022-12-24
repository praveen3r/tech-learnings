import App from "./app";
import 'dotenv/config';
import AuthRoute from "./router/AuthRoute";
import UserRoute from "./router/UserRoute";
import GenderRoute from "./router/GenderRoute";
import CacheClearRoute from "./router/CacheClearRoute";

const app = new App(
    [new AuthRoute(), new UserRoute(), new GenderRoute(), new CacheClearRoute()],
    Number(process.env.PORT)
);

app.listen();