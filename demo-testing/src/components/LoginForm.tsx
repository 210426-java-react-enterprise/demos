import {useState} from "react";
import {Col, Container, Row, Form, Card, Button, Modal, FormControl} from "react-bootstrap";
import CardHeader from "react-bootstrap/esm/CardHeader";
import {LoginBackendCall} from "../remote/login-service";

interface Iloginprop{

}
export function LoginForm (props:Iloginprop){

    //some hooks for the text fields
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password,setPassword] = useState("");

    const [result, setResult] = useState({
    })

    const [show,setShow] = useState(false);
    const handleClose = ()=> setShow(false);

    let login =async (e:any)=>{
        e.preventDefault();
        const user = await LoginBackendCall();
        setResult(user);
        setShow(true);
        console.log("Logged In user:",user);
    }

    return(
        <>
         <Container>
             <Row>
                 <Col>
                     <Card>
                         <Card.Title id="title-card">Login Form</Card.Title>
                         <Card.Body>
                             <Form className="row px-4">
                                 <Form.Group>
                                     <Form.Label id="label-username">Username:</Form.Label>
                                     <Form.Control
                                         type="text"
                                         id="username"
                                         placeholder="Username"
                                         name="username"
                                         value={username}
                                         onChange={(e)=>setUsername(e.target.value)}>
                                     </Form.Control>
                                 </Form.Group>
                                 <Form.Group>
                                     <Form.Label id="label-password">Password:</Form.Label>
                                     <Form.Control
                                         type="text"
                                         id="password"
                                         placeholder="Password"
                                         name="password"
                                         value={password}
                                         onChange={(e)=>setPassword(e.target.value)}>
                                     </Form.Control>
                                 </Form.Group>
                                 <Form.Group className="text-center col-12">
                                     <Button className="button" data-testid="submit-btn" variant="danger" type="submit" onClick={login}>
                                         Submit
                                     </Button>
                                 </Form.Group>
                             </Form>
                         </Card.Body>
                     </Card>
                 </Col>
             </Row>
         </Container>
        <Modal  data-testid="containerModal" id="modalContainer" show={show} onHide={handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>Button Clicked Information</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <ul id="un-list">
                    {result && Object.values(result).map((val,index)=>{
                        return(
                            val
                            &&
                            <li key={index}>{val}</li>
                        )
                    })}
                </ul>
            </Modal.Body>
        </Modal>
    </>
    )
}

