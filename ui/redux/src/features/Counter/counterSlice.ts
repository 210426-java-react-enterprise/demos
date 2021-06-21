import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { RootState  } from "../../app/store";

// Declare a State interface which sets the types needed inside of initial state object
interface State {
    count: number;
    isLoading: boolean;
    textArray: string[];
    data: object;
}

// Declare the initialState, this is what the state will be when the application loads 
//before dispatching actions which use reducers defined below to maniupulate the application state
const initialState: State = {
    count: 0,
    isLoading: false,
    textArray: [],
    data: {}
};

/* Define the state slice, using createSlice hook
    - this takes in a name, initialState (defined above), and then you define the reducers
    - the reducers in this example are both the REDUCER AND THE ACTION COMBINED
    - within the reducer, define how the state will be manipulated
    - if there is a payload that needs to be store in state, include that (state, action: PayloadAction<type>) in the reducer definition
*/
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

// Export the reducers (which are both reducer definitions AND ACTIONS) here to be imported into your components when needed
export const { increment, decrement, isLoading, isLoaded, resetCount, addWord, loadData } = counterSlice.actions;

// Export the entire state object, this is what you will pass into useSelector(here) when you bring the state into any component you may need it in
export const countState = (state: RootState) => state.counter;

// Export entire slice, to be included in the main store here
export default counterSlice.reducer;