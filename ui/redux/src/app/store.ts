import { configureStore } from "@reduxjs/toolkit";
import counterReducer from "../features/Counter/counterSlice";

// Configure the store reducer, to combine each individual state slice into one component state, 
//redux does this for you under the hood based on this reducer object
export const store = configureStore({
  reducer: {
    counter: counterReducer,
  },
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
