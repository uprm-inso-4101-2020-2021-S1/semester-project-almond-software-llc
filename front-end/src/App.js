import React from 'react';
import "date-fns";
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
        <Route path="/" exact component={Login} />
        <Route path="/home" exact component={Main}/>
        <Route path="/register" exact component={Register} />
      </Switch>
    </Router>
  );
}
export default App;
