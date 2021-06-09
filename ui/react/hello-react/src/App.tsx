import React, { useState } from 'react';
import {BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import logo from './logo.svg';
import './App.css';
import { LoginComponent } from './components/LoginComponent';
import { LoginComponent_Class } from './components/LoginComponent_Class';
import { User } from './models/user';
import HomeComponent from './components/HomeComponent';
import { AppBar, Toolbar, Typography } from '@material-ui/core';
import NavbarComponent from './components/NavbarComponent';

function App() {

  const [authUser, setAuthUser] = useState(undefined as User | undefined);

  const mockFlashcards = [
    {
      id: 1,
      question: 'question-1',
      answer: 'answer-1'
    },
    {
      id: 2,
      question: 'question-2',
      answer: 'answer-2'
    },
    {
      id: 3,
      question: 'question-3',
      answer: 'answer-3'
    }
  ]

  return (
    <>
      <Router>

          <NavbarComponent currentUser={authUser} setCurrentUser={setAuthUser}/>

          <Switch>
            <Route path="/home" render={() => <HomeComponent currentUser={authUser} flashcards={mockFlashcards}/>} />
            <Route path="/" render={() => <LoginComponent authUser={authUser} setAuthUser={setAuthUser} />} />
          </Switch>
          
      </Router>
    </>
  );
}

export default App;
