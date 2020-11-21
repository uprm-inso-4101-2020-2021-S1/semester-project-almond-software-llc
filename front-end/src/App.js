import React, { useState, useEffect } from 'react';
import "date-fns";
//import Main from './main/Main.js';
import Main from './main/Main_COPY.js';
import './App.css';
import Login from './main/userauthentication/Login';
import Register from "./main/userauthentication/Register";
import { BrowserRouter as Router } from "react-router-dom";
import { Switch, Route } from "react-router-dom";

function App() {

  const [currUser, setCurrUser] = useState("");

  return (
    <Router>
      <Switch>
        <Route path="/" exact>
          <Login currUser={currUser} setCurrUser={setCurrUser} />
        </Route>
        <Route path="/home" exact>
          <Main currUser={currUser} />
        </Route>
        <Route path="/register" exact>
          <Register />
        </Route>
      </Switch>
    </Router >
  );
}
export default App;
