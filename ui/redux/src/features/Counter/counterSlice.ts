import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { RootState  } from "../../app/store";

interface State {
    count: number;
    isLoading: boolean;
    textArray: string[];
    data: object;
}

const initialState: State = {
    count: 0,
    isLoading: false,
    textArray: [],
    data: {}
};

export const counterSlice = createSlice({
    name: "counter",
    initialState,
    reducers: {
        increment: (state) => {
            state.count += 1;
        },
        decrement: (state) => {
            state.count -= 1;
        },
        isLoading: (state) => {
            state.isLoading = true;
        },
        isLoaded: (state) => {
            state.isLoading = false;
        },
        resetCount: (state) => {
            state.count = 0;
        },
        addWord: (state, action: PayloadAction<string>) => {
            state.textArray.push(action.payload);
        },
        loadData: (state, action: PayloadAction<object>) => {
            state.data = action.payload;
        }

    }
});

export const { increment, decrement, isLoading, isLoaded, resetCount, addWord, loadData } = counterSlice.actions;

export const countState = (state: RootState) => state.counter;

export default counterSlice.reducer;