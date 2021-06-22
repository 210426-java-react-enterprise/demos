import { Row, Col, Container } from "react-bootstrap";
/*
  Import redux hooks into the component
  - useSelector() - this will give you access to the state declared inside of your slice, you will pass in a reference to the slice
  - useDispatch() - this will be your dispatcher, initialize in component with const dispatch = useDispatch();
  - dispatch actions by useing dispatch(actionYouWantToDispatch());
  - if you have a payload you want to send back to store to be stored in state and if your action takes a payload 
    (as defined in the state slice) pass the payload into the action
  - dispatch(action(payload))
  - if the payload is an object, dispatch({ key: value, key2: value2 })
*/
import { useSelector, useDispatch } from "react-redux";

/*
  - Import the actions and state object that is exported from state slice to be used in component
  - These are imported from the state slice, they represent individual reducers
  - Reducers are defined in the state slice, they manipulate your state
*/
import {
  increment,
  decrement,
  isLoading,
  isLoaded,
  countState,
} from "../features/Counter/counterSlice";
import Loader from "./Loader";

const Counter = () => {
  //Initilize your dispatcher
  const dispatch = useDispatch();

  // Initliaze your local state object by passing in the state exported from your slice into useSelector()
  const count = useSelector(countState);

  const handleIncrement = (e: any) => {

    //dispatch an action that you have imported into your component
    dispatch(isLoading());

    setTimeout(() => {
      // you can also dispatch several actions back to back, giving you more control over the state of the entire application
      dispatch(increment());
      dispatch(isLoaded());
    }, 1000);
  };

    const handleDecrement = (e: any) => {
      dispatch(isLoading());
      setTimeout(() => {
        dispatch(decrement());
        dispatch(isLoaded());
      }, 1000);
  };

  return (
    <Container>
      <Row className="d-flex justify-content-center">
        <Col
          xs={10}
          md={8}
          lg={6}
          style={{ height: "100px" }}
          className="border bg-dark text-light"
        >
          <Row>
            <Col>
              <div onClick={handleIncrement} className="increment">
               &lt;
              </div>
            </Col>
            <Col>
              <div className="count">
                {count.isLoading ? <Loader /> : count.count}
              </div>
            </Col>
            <Col>
              <div onClick={handleDecrement} className="decrement">
                &gt;
              </div>
            </Col>
          </Row>
        </Col>
      </Row>
    </Container>
  );
};

export default Counter;
