import React, { useState } from 'react';
import {BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import logo from './logo.svg';
import './App.css';
import { LoginComponent } from './components/LoginComponent';
import { LoginComponent_Class } from './components/LoginComponent_Class';
import { User } from './models/user';
import HomeComponent from './components/HomeComponent';

function App() {

  // @ts-ignore
  const [authUser, setAuthUser] = useState(null as User);

  return (
    <>
      <Router>
          <Switch>
            <Route path="/home" render={() => <HomeComponent username={authUser?.username}/>} />
            <Route path="/" render={() => <LoginComponent authUser={authUser} setAuthUser={setAuthUser} />} />
          </Switch>
      </Router>
    </>
  );
}

export default App;
