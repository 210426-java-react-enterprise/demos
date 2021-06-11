import configureStore from 'redux-mock-store';
import { Provider } from 'react-redux';
import { mount, shallow } from 'enzyme';
import Enzyme from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { createMount } from '@material-ui/core/test-utils';

import { render, queryByAttribute } from '../test-utils'
import LoginComponent from '../components/login-component/LoginContainer';
import { Alert } from '@material-ui/lab';


// without Enzyme
test('Renders the LoginComponent with initialState', () => {

    const getById = queryByAttribute.bind(null, 'id');

    let stateArg = { 
        initialState: { 
            login: {
                authUser: undefined,
                errorMessage: ''
            } 
        }
    };
    const dom = render(<LoginComponent />, stateArg);
    expect(getById(dom.container, 'login-component')).toBeTruthy();
    expect((getById(dom.container, 'username') as HTMLInputElement)?.value).toBe('');
    expect((getById(dom.container, 'password') as HTMLInputElement)?.value).toBe('');
    expect(getById(dom.container, 'error-message')).toBeFalsy();
});

// With Enzyme
Enzyme.configure({ adapter: new Adapter() });
test('Renders the LoginComponent with initialState', () => {

    const configureMockStore = configureStore(); 

    let initialState = { 
        login: {
            authUser: undefined,
            errorMessage: ''
        } 
    }

    const mockStore = configureMockStore(initialState);

    // createMount is a wrapper around Enzyme's mount function (provided by Material-UI)
    // if not using Material UI, simply use Enzyme.mount
    const component = createMount()(
        <Provider store={mockStore}>
            <LoginComponent />
        </Provider>
    );

    console.log(component.find('input#username').debug());
    expect(component.find('div#login-component')).toBeTruthy();
    expect(component.find('input#username').text()).toBe('');
    expect(component.find('input#password').text()).toBe('');
    expect(component.find('#error-message').at(0).exists()).toBe(false);
});

// test('Clicking login button with no provided username or password renders error message', () => {

//     const getById = queryByAttribute.bind(null, 'id');

//     let stateArg = { 
//         initialState: { 
//             login: {
//                 authUser: undefined,
//                 errorMessage: ''
//             } 
//         }
//     };
//     const dom = render(<LoginComponent />, stateArg);
//     try {
//         getById(dom.container, 'login-button')?.click();
//     } catch (e) {
//         expect(getById(dom.container, 'error-message')).toBeTruthy();
//     }
    
// });