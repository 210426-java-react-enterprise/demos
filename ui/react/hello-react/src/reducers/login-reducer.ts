import { AnyAction } from "redux";
import { ILoginState } from ".";
import { loginActionTypes } from "../actions/login-action";
import { User } from "../models/user";

const initialState: ILoginState = {
    authUser: (undefined as User | undefined),
    errorMessage: ''
}

export const loginReducer = (state: ILoginState = initialState, action: AnyAction) => {
    
    console.log(`loginReducer invoked with action:`, action);

    switch (action.type) {
        case loginActionTypes.SUCCESSFUL_LOGIN:
            let newState = {
                ...state,
                authUser: action.payload
            };
            console.log(`Reducing ${loginActionTypes.SUCCESSFUL_LOGIN} to new state`, newState);
            return newState;
        case loginActionTypes.NO_CREDENTIALS_PROVIDED:
        case loginActionTypes.BAD_REQUEST:
        case loginActionTypes.INVALID_CREDENTIALS:
        case loginActionTypes.INTERNAL_SERVER_ERROR:
            return {
                ...state,
                errorMessage: action.payload
            }
        default:
            return state;
    }
}