import { Row, Col, Form, Button } from "react-bootstrap";

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
import { countState } from "../../features/Counter/counterSlice";
import { useState } from "react";
import { addWord, loadData } from "../../features/Counter/counterSlice";
import { currentWeather } from "../../Utility/api";

const WordForm = () => {

  // Initialize your dispatcher
  const dispatch = useDispatch();

  //Initialize the store variable you will need access to by passing in the state object you exported from the state slice and imported at the top here.
  const count = useSelector(countState);

  // You may also find it useful to use useState for compenent level variables you do not need store in the central state object
  const [word, setWord] = useState("");

  const handleAddText = (e: any) => {
    e.preventDefault();
    dispatch(addWord(word));
      setWord("");
    currentWeather(word).then(res => {

        /* Dispatch an action that takes in a payload that you want to be stored in the application state by passing it into the action declaration.
          - dispatch(actionToBeDispatched(payload));
          - this is accessed inside of the state slice within the reducer definition using action.payload
          - if is an object, pass the object into the action dispatch(actionToBeDispatched({ key: value, key: value }));
          - it is then accessed within the state slice with action.payload.key
          */
      
          dispatch(loadData(res));
      }).catch(err => console.log(err));
      
  };

  return (
    <>
      <Row>
        <Col>
          <Form>
            <Form.Group>
              <Form.Control
                type="text"
                id="word"
                name="word"
                value={word}
                onChange={(e) => setWord(e.target.value)}
              ></Form.Control>
            </Form.Group>
            <Button onClick={handleAddText}>Add Word</Button>
          </Form>
        </Col>
      </Row>
      <Row>
        <Col>{count.textArray}</Col>
      </Row>
    </>
  );
};

export default WordForm;
