import React from 'react';
import ReactDOM from 'react-dom';

// Import provider from react-redux
import { Provider } from "react-redux";

// import store from where ever you have your store.ts file defined
import { store } from "./app/store";

import "bootstrap/dist/css/bootstrap.min.css";
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

/*
Wrap entire application with Provider tags and give it the attribute store={store} to provide the entire application with the redux store
*/
ReactDOM.render(
  <React.StrictMode>    
    <Provider store={store}>
      <App />
    </Provider>
    
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
