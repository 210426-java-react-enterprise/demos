import { Dispatch } from 'redux';
import { authenticate } from "../remote/auth-service";

export const loginActionTypes = {
    NO_CREDENTIALS_PROVIDED: 'QUIZZARD_NO_CREDENTIALS_PROVIDED',
    SUCCESSFUL_LOGIN: 'QUIZZARD_SUCCESSFUL_LOGIN',
    BAD_REQUEST: 'QUIZZARD_BAD_REQUEST',
    INVALID_CREDENTIALS: 'QUIZZARD_INVALID_CREDENTIALS',
    INTERNAL_SERVER_ERROR: 'QUIZZARD_INTERNAL_SERVER_ERROR'
}

export const loginAction = (username: string, password: string) =>  async (dispatch: Dispatch) => {
    
    if (!username || !password) {
        dispatch({
            type: loginActionTypes.NO_CREDENTIALS_PROVIDED,
            payload: 'You must provide a username and a password!'
        })
        return;
    }

    try {
        console.log(`Attempting to login using credentials ${username} ${password}...`);
        let authUser = await authenticate(username, password);
        console.log('Authentication successful!');
        
        console.log(`Attempting to dispatch: ${loginActionTypes.SUCCESSFUL_LOGIN}...`);
        // If login is successful, we will dispatch an action that specifies that
        // (include the payload which will be the piece of information we want to use to change the state store)
        dispatch({
            type: loginActionTypes.SUCCESSFUL_LOGIN,
            payload: authUser
        });

        console.log(`${loginActionTypes.SUCCESSFUL_LOGIN} dispatched!`);

    } catch (e) {

        console.log('Error caught!');
        console.dir(e);
        let status = e.response.status;

        if (status === 400) {
            dispatch({
                type: loginActionTypes.BAD_REQUEST,
                payload: e.response.data.message || 'Client made a bad request to the server!'
            });
        } else if (status === 401) {
            dispatch({
                type: loginActionTypes.INVALID_CREDENTIALS,
                payload: e.response.data.message || 'Could not find an account with the provided credentials!'
            });
        } else {
            dispatch({
                type: loginActionTypes.INTERNAL_SERVER_ERROR,
                payload: e.response.data.message || 'Uh oh! We could not reach the server'
            })
        }
    }

}