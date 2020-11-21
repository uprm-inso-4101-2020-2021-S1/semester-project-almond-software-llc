import React,{useState} from 'react';
import "date-fns";
//import Main from './main/Main.js';
import Main from './main/Main_COPY.js';
import './App.css';
import Login from './main/UserAuthentication/login';
import Register from "./main/UserAuthentication/register";
import { BrowserRouter as Router, useHistory } from "react-router-dom";
import {Switch, Route } from "react-router-dom";


function App() {
  const history = useHistory();
  const [loggedInStatus, setLoggedInStatus] = useState(String);
  let [user, password] = useState(null);

  const handleSuccessfulAuth = (data) => {
    this.props.handleLogin(data);
    history.push("/home");
  }

  const checkLoginStatus = () =>{
    axios.get("http://localhost:8080/login?"
      + "user=" + user + "&password=" + password
    ).then(response => {
        if (
          response.data.logged_in &&
          loggedInStatus === "NOT_LOGGED_IN"
        ) {
          setLoggedInStatus({
            loggedInStatus: "LOGGED_IN",
            user: response.data.user
          });
        } else if (
          !response.data.logged_in &
          (loggedInStatus === "LOGGED_IN")
        ) {
          this.setState({
            loggedInStatus: "NOT_LOGGED_IN",
            user: {}
          });
        }
      })
      .catch(error => {
        console.log("check login error", error);
      });
  }

  const componentDidMount = () =>{
    this.checkLoginStatus();
  }



  const handleLogin = (data) => {
    setLoggedInStatus({
      loggedInStatus: "LOGGED_IN",
      user: data.user
    });
  }

  return (
    <Router>
      <Switch>
        <Route
          path="/"
          exact
          component={Login}
          handleLogin={(e) => handleLogin(e)}
          loggedInStatus={loggedInStatus}
          handleSuccessfulAuth={(e) => handleSuccessfulAuth(e)}
        ></Route>
        <Route
          path="/home"
          exact
          component={Main}
          loggedInStatus={loggedInStatus}
        />
        <Route path="/register" exact component={Register} />
      </Switch>
    </Router>
  );
}
export default App;
