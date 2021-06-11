import { render, queryByAttribute } from '../test-utils'
import { mapStateToProps, mapDispatchToProps } from '../components/login-component/LoginContainer';
import { loginAction } from '../actions/login-action';

test('LoginContainer should map state to props', () => {
    
    const mockState = { 
        login: {
            authUser: undefined,
            errorMessage: ''
        } 
    };
    
    const props = {
        authUser: undefined,
        errorMessage: ''
    };

    expect(mapStateToProps(mockState)).toEqual(props);

});
