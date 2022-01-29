import { createStore } from "redux";
import rootReducer from "./RootReducer";

const rootStore = createStore(rootReducer);

export default rootStore