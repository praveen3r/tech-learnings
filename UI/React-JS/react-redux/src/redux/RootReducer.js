import { createStore } from "redux";
import { combineReducers } from "redux";
import reducer from "../cake/Reducer";
import iceCreamReducer from "../ice-cream/IceCreamReducer";

const rootReducer = combineReducers({
    cake: reducer,
    iceCream: iceCreamReducer
})

export default rootReducer