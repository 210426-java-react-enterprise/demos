import { Row, Col, Form, Button } from "react-bootstrap";
import { useSelector, useDispatch } from "react-redux";
import { countState } from "../../features/Counter/counterSlice";
import { useState } from "react";
import { addWord, loadData } from "../../features/Counter/counterSlice";
import { currentWeather } from "../../Utility/api";

const WordForm = () => {
  const dispatch = useDispatch();
  const count = useSelector(countState);
  const [word, setWord] = useState("");

  const handleAddText = (e: any) => {
    e.preventDefault();
    dispatch(addWord(word));
      setWord("");
      currentWeather(word).then(res => {
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
