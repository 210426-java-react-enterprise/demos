import { Row, Col, Button } from "react-bootstrap";
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
import { useDispatch } from "react-redux";

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
  resetCount,
  
} from "../../features/Counter/counterSlice";

const ButtonGroup = () => {
  //Initilize your dispatcher
  const dispatch = useDispatch();

  const handleIncrement = (e: any) => {
    e.preventDefault();
    // dispatch an action
    dispatch(isLoading());
    setTimeout(() => {
      // you may also dispatch several actions at once, one after the other, giving you more control over the application state.
      dispatch(increment());
      dispatch(isLoaded());
    }, 1000);
  };

  const handleDecrement = (e: any) => {
    e.preventDefault();
    dispatch(isLoading());
    setTimeout(() => {
      dispatch(decrement());
      dispatch(isLoaded());
    }, 1000);
  };

  const handleReset = (e: any) => {
    e.preventDefault();
    dispatch(isLoading());
    setTimeout(() => {
      dispatch(resetCount());
      dispatch(isLoaded());
    }, 1000);
  };

  return (
    <Row>
      <Col className="d-flex justify-content-center">
        <Button onClick={handleIncrement}>Add</Button>

        <Button onClick={handleDecrement}>Subtract</Button>

        <Button onClick={handleReset}>Reset</Button>
      </Col>
    </Row>
  );
}

export default ButtonGroup;
