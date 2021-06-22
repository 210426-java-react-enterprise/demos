import {BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import './App.css';
import LoginComponent from './components/login-component/LoginContainer';
import HomeComponent from './components/home-component/HomeContainer';
import NavbarComponent from './components/navbar-component/NavbarComponent';
import { store } from './Store';
import { Provider } from 'react-redux';

function App() {

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
      <Provider store={store}>
        <Router>

            <NavbarComponent currentUser={undefined} />

            <Switch>
              <Route path="/home" render={() => <HomeComponent />} />
              <Route path="/" render={() => <LoginComponent />} />
            </Switch>

        </Router>
      </Provider>
    </>
  );
}

export default App;
