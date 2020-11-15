import React from 'react';
import "date-fns";
import ReactDOM from 'react-dom';
import 'bootstrap';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import 'bootstrap/dist/css/bootstrap.min.css';
//import Main from './main/Main.js';
import Login from "./main/UserAuthentication/login";
//import Register from './main/UserAuthentication/register';
import { BrowserRouter as Router } from "react-router-dom";

ReactDOM.render(
  <Router>
    <App/>
  </Router>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
