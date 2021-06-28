import React from 'react';
import {LoginForm} from "./components/LoginForm";
import {BrowserRouter, Route} from "react-router-dom";
import {Container} from "react-bootstrap";

function App() {
  return (
      <>
         <Container>
             <LoginForm/>
         </Container>

      </>
  );
}

export default App;
