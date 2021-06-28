import Enzyme, {mount, ReactWrapper, shallow} from "enzyme";
import Adapter from "@wojtekmaj/enzyme-adapter-react-17";
import {LoginForm} from "../components/LoginForm";
import { render,fireEvent , act } from "@testing-library/react";
import {loginModel} from "../model/login-model";
import { LoginBackendCall } from "../remote/login-service";
import {Modal} from "react-bootstrap"

Enzyme.configure({adapter:new Adapter()});

jest.mock("../remote/login-service",()=> {
    return{
        LoginBackendCall:jest.fn()
    }
});
//Describe is a group of test, we group similar test.
describe("Login Form",()=>{

    //declare our wrapper for all test to use, if we declare it in beforeEach we will not have access to it
    //for all other test.
    let wrapper:ReactWrapper;

    //runs before each test, we mount the wrapper, which will give us access to children elements in the
    //DOM
    beforeEach(()=>{
        wrapper = mount(<LoginForm/>);
    })

    afterAll(()=>{
        wrapper.unmount();
    })

    //test(): takes two parameters, description and callback function.
    //what gets chained with the expect method is called a matcher
    //  + few matchers( toBe(), toEqual(), toBeNull(),toBeTruthy...)
    //Here we test that our mounted component exist.
    test("Testing the Login Form render",()=>{
        expect(wrapper.exists()).toBe(true);
    })

    /*
        .find(): I use a combination tag name and the id attribute.
            + < input id ="example-id"></input> ====> .find("input#example-id)
            + for id we prefix it with hashtag, #example-id
            + for classname use a period( below button uses that syntax).
        enzyme for more selectors(the way to use find()) => https://enzymejs.github.io/enzyme/docs/api/selector.html

     */
    test("Testing Component Display Properly",()=>{

        //console.log(wrapper.find("CardTitle").debug());


        //.text() returns the text between the Tag element
        //our text field has the value equal to the hook username, which by
        //default is empty, thus at the start of render should be empty.
        expect(wrapper.find("FormControl#username").text()).toBe("");
        expect(wrapper.find("FormControl#password").text()).toBe("");
        //button
        //here is an example on how to find by className user  .
        expect(wrapper.find("Button.button").text()).toBe("Submit");
        //Header
        expect(wrapper.find("div#title-card").text()).toBe("Login Form");
        //2 Labels
        expect(wrapper.find("label#label-username").text()).toBe("Username:");
        expect(wrapper.find("label#label-password").text()).toBe("Password:");


    });


    //chain it with .toEqual because we compare values and toBe() compares objects.
    test("Testing attributes for Username Form Control",()=>{

        //.props() returns the current node(dom element) props
        expect(wrapper.find("FormControl#username").props()).toEqual({
            type:"text",
            id:"username",
            placeholder:"Username",
            name:"username",
            value:"",
            onChange:expect.any(Function)// onChange takes in a function
        })
    });


    test("Input Username onChange",()=>{

        /*
            render from testing-library/react.
            we deconstruct the render to get back query methods, there is alot and they are all pre-fixed with query.
            The query methods are used to find DOM elements.
         */
        const { queryAllByTestId,queryByPlaceholderText } = render(<LoginForm/>);
        //this query method finds by placehold text
        const inputUsername = queryByPlaceholderText("Username");
        //fireEvent is chained right after the desired event that we want to happen can be click, check, onChange=change, etc.
        fireEvent.change(inputUsername,{target:{value:"test-username"}});//.change():expects the DOM element, what we will target(options)
        expect(inputUsername.value).toEqual("test-username")

    });

    test("Input Password onChange",()=>{

        const { queryAllByTestId,queryByPlaceholderText } = render(<LoginForm/>);
        const inputPassword = queryByPlaceholderText("Password");
        fireEvent.change(inputPassword,{target:{value:"test-username"}});
        expect(inputPassword.value).toBe("test-username")
    });

    //
    test("simulate button click",async ()=>{
        //act method wraps an event, if state will change and working with async code.
        //I used it because the terminal advised it.
        await act(async ()=>{
            const { queryByTestId } = render(<LoginForm/>);
            // if using this query method, then must use the attribute (data-testid)
            //example <Button data-testid="submit-btn"/>
            const buttonSim = queryByTestId("submit-btn");
            fireEvent.click(buttonSim)
        })
        expect(LoginBackendCall).toHaveBeenCalled()
    });

})




describe("Mock Testing our axios function",()=>{

    test("mock testing the axios 2 call",async ()=>{
        //object that we will resolve, so what is returned from your async function.
        let DTO:loginModel = {
            id:32,
            firstName:"Juan Test",
            lastName:"Mendoza-Test"
        }
        const { queryByTestId } = render(<LoginForm/>);
        //we cast our component to a jest.Mock type, and chain it and give it some implementation.
        //recall our jest.mock("../remote/LoginBackendCall) on top of this test returns the function as a
        //jest function and still has no implementation.
        (LoginBackendCall as jest.Mock).mockImplementation(()=>{

                // async code like axios returns a promise, so return a new promise
                //resolve is a function and we choose what we want to resolve, in this case our DTO.
                return new Promise(resolve => resolve(DTO));
        });

        await act(async ()=>{
            const buttonSim = queryByTestId("submit-btn");
            fireEvent.click(buttonSim)
        });


        const received = await LoginBackendCall();
        expect(LoginBackendCall).toHaveBeenCalled();
        expect(queryByTestId("containerModal")).toBeInTheDocument();
        expect(received).toEqual(DTO);
        expect(queryByTestId("containerModal").querySelectorAll("li").length).toEqual(3);

    })

    test("Modal Logic no list or render ",()=>{
        const wrapper = mount(<LoginForm/>);
        console.log(wrapper.find("li").debug());
        const { queryByTestId} = render(<LoginForm/>);
        const modalcon = queryByTestId("modalContainer");
        expect(modalcon).not.toBeInTheDocument();

        expect(wrapper.find("li").length).toBe(0);


    })

})