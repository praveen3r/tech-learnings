import { applyMiddleware, createStore } from "redux";
import rootReducer from "./RootReducer";
import {logger} from 'redux-logger'

const RootStoreWithMiddleWare = createStore(rootReducer, applyMiddleware(logger));

export default RootStoreWithMiddleWare