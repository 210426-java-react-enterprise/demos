import { mapStateToProps } from "../components/login-component/LoginContainer";

// Use "describe" to set up a suite of tests
// each test within the suite would be within a "it" function

// describe('test suite', () => {

//     beforeEach(() => {

//     });

//     it('individual test 1 description', () => {});

//     it('individual test 2 description', () => {});

// });

// individual tests that have no common set up
test('LoginContainer should map state to props (all falsy values)', () => {

    // Arrange
    const mockState = {
        login: {
            authUser: undefined,
            errorMessage: ''
        }
    };

    const expectedProps = {
        authUser: undefined,
        errorMessage: ''
    }


    // Act
    let actualProps = mapStateToProps(mockState);

    // Assert
    expect(actualProps).toEqual(expectedProps);
});


test('LoginContainer should map state to props (with truthy error message)', () => {

    // Arrange
    const mockState = {
        login: {
            authUser: undefined,
            errorMessage: 'Test error message'
        }
    };

    const expectedProps = {
        authUser: undefined,
        errorMessage: 'Test error message'
    }


    // Act
    let actualProps = mapStateToProps(mockState);

    console.log(actualProps);

    // Assert
    expect(actualProps).toEqual(expectedProps);
});