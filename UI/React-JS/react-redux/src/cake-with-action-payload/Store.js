import { createStore } from "redux";
import newCakeReducer from "./Reducer";

const newCakeStore = createStore(newCakeReducer);

export default newCakeStore