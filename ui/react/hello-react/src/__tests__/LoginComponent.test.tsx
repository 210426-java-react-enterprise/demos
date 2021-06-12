import { queryByAttribute } from "@testing-library/react";
import Enzyme from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { createMount } from '@material-ui/core/test-utils';
import configureStore from 'redux-mock-store';
import { Provider } from 'react-redux';

import LoginComponent from "../components/login-component/LoginContainer";
import { render } from "../test-utils";

// without Enzyme
test('Renders the LoginComponent with initial state', () => {

    const getById = queryByAttribute.bind(null, 'id');

    let stateArg = {
        initialState: {
            login: {
                authUser: undefined,
                errorMessage: ''
            }
        }
    }
    
    const dom = render(<LoginComponent />, stateArg);

    expect(getById(dom.container, 'login-component')).toBeTruthy();
    expect((getById(dom.container, 'username') as HTMLInputElement).value).toBe('');
    expect((getById(dom.container, 'password') as HTMLInputElement).value).toBe('');
    expect(getById(dom.container, 'error-message')).toBeFalsy();

});


test('Renders the LoginComponent with initial state', () => {

    const getById = queryByAttribute.bind(null, 'id');

    let stateArg = {
        initialState: {
            login: {
                authUser: undefined,
                errorMessage: 'Truthy'
            }
        }
    }
    
    const dom = render(<LoginComponent />, stateArg);

    expect(getById(dom.container, 'login-component')).toBeTruthy();
    expect((getById(dom.container, 'username') as HTMLInputElement).value).toBe('');
    expect((getById(dom.container, 'password') as HTMLInputElement).value).toBe('');
    expect(getById(dom.container, 'error-message')).toBeTruthy();

});

// With Enzyme
Enzyme.configure({ adapter: new Adapter() }); // only do this once
test('Renders the LoginComponent with initialState', () => {

    const configureMockStore = configureStore();

    let initialState = {
        login: {
            authUser: undefined,
            errorMessage: ''
        }
    }

    const mockStore = configureMockStore(initialState);

    // createMount is a wrapper around Enzyme's mount function; createMount is provided
    // by Material UI.

    // if not using Material UI, simply use Enzyme's mount function
    const wrapper = createMount()(
        <Provider store={mockStore}>
            <LoginComponent />
        </Provider>
    );

    console.log(wrapper.find('input#username')); // this will tell you that it is an empty object (it is not!) [use .debug()]
    console.log(wrapper.find('input#username').debug());
    expect(wrapper.find('div#login-component')).toBeTruthy();
    expect(wrapper.find('input#username').text()).toBe('');
    expect(wrapper.find('input#password').text()).toBe('');
    expect(wrapper.find('#error-message').at(0).exists()).toBe(false);

});

test('Renders the LoginComponent with initialState', () => {

    const configureMockStore = configureStore();

    let initialState = {
        login: {
            authUser: undefined,
            errorMessage: 'Truthy error message'
        }
    }

    const mockStore = configureMockStore(initialState);

    // createMount is a wrapper around Enzyme's mount function; createMount is provided
    // by Material UI.

    // if not using Material UI, simply use Enzyme's mount function
    const wrapper = createMount()(
        <Provider store={mockStore}>
            <LoginComponent />
        </Provider>
    );


    expect(wrapper.find('div#login-component')).toBeTruthy();
    expect(wrapper.find('input#username').text()).toBe('');
    expect(wrapper.find('input#password').text()).toBe('');
    expect(wrapper.find('#error-message').at(0).exists()).toBe(true);

});

test('When login button is click and no username/password is provided, proper error message should display', () => {

    const configureMockStore = configureStore();

    let initialState = {
        login: {
            authUser: undefined,
            errorMessage: ''
        }
    }

    const mockStore = configureMockStore(initialState);

    const wrapper = createMount()(
        <Provider store={mockStore}>
            <LoginComponent />
        </Provider>
    );

    // Simulate a click event on the login button (with no username or password being set)
    // Check to see that the error message does render with the appropriate message

})