import { Row, Col, Button } from "react-bootstrap";
import {  useDispatch } from "react-redux";
import {
  increment,
  decrement,
  isLoading,
    isLoaded,
  resetCount,
  
} from "../../features/Counter/counterSlice";

const ButtonGroup = () => {

      const dispatch = useDispatch();
      
    const handleIncrement = (e: any) => {
        e.preventDefault();
        dispatch(isLoading());
        setTimeout(() => {
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
