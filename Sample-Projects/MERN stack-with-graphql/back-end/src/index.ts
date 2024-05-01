import "dotenv/config";
import App from "./app";
import AuthRoute from "./router/AuthRoute";
import CacheClearRoute from "./router/CacheClearRoute";
import GenderRoute from "./router/GenderRoute";
import UserRoute from "./router/UserRoute";
import UserRouteWithGraphQl from "./router/UserRouteWithGraphql";

const app = new App(
  [
    new AuthRoute(),
    new UserRoute(),
    new UserRouteWithGraphQl(),
    new GenderRoute(),
    new CacheClearRoute(),
  ],
  Number(process.env.PORT)
);

app.listen();
