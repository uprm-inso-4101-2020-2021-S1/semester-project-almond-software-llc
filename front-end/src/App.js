import React from 'react';
import Main from './main/Main.js';
import './App.css';
import Login from './main/UserAuthentication/login';
import Register from "./main/UserAuthentication/register";
import { BrowserRouter as Router } from "react-router-dom";
import {Switch, Route } from "react-router-dom";


function App() {
  return (
    <Router>
      <Switch>
        <Route path="/home" exact component={Main} />
        <Route path="/login" exact component={Login}/>
        <Route path="/register" exact component={Register} />
      </Switch>
    </Router>
  );
}
export default App;
