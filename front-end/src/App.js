import React, { useState, useEffect } from 'react';
import "date-fns";
import Main from './main/Main.js';
import './App.css';
import Login from './main/userauthentication/Login';
import Register from './main/userauthentication/Register';
import { BrowserRouter as Router } from "react-router-dom";
import { Switch, Route } from "react-router-dom";

function App() {
  return (
    <Router>
      <Switch>
        <Route path="/" exact>
          <Login />
        </Route>
        <Route path="/home" exact>
          <Main />
        </Route>
        <Route path="/register" exact>
          <Register />
        </Route>
      </Switch>
    </Router >
  );
}
export default App;

