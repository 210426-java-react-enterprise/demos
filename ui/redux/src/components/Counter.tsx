import { Row, Col, Container } from "react-bootstrap";
import { useSelector, useDispatch } from "react-redux";
import {
  increment,
  decrement,
  isLoading,
  isLoaded,
  countState,
} from "../features/Counter/counterSlice";
import Loader from "./Loader";

const Counter = () => {
  const dispatch = useDispatch();
  const count = useSelector(countState);

  const handleIncrement = (e: any) => {
    dispatch(isLoading());
    setTimeout(() => {
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
