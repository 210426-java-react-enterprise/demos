import { applyMiddleware, compose, createStore, Store } from "redux";
import reduxThunk from 'redux-thunk';
import { state } from "./reducers";

// Lines 6-11 and line 15 are related configuring the Redux DevTools plugin
const a: any = window;
const composeEnhancers = a.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const enhancers = composeEnhancers(
    applyMiddleware(reduxThunk)
);

export const store: Store<any> = createStore(
    state,
    enhancers
);