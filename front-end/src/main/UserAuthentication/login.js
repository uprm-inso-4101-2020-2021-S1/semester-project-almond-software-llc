import React, { useState } from "react";
import Macademia from "./macademia.png";
import Button from "@material-ui/core/Button";
import CssBaseline from "@material-ui/core/CssBaseline";
import TextField from "@material-ui/core/TextField";
import Link from "@material-ui/core/Link";
import Grid from "@material-ui/core/Grid";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";
import { BrowserRouter as Router, useHistory } from "react-router-dom";
import Container from "@material-ui/core/Container";
import axios from "axios";

const useStyles = makeStyles((theme) => ({
  paper: {
    marginTop: theme.spacing(8),
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
  },
  image: {
    width: 60,
    height: 60,
    backgroundColor: "green",
    borderRadius: "50%",
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main,
  },
  form: {
    width: "100%", // Fix IE 11 issue.
    marginTop: theme.spacing(1),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
    backgroundColor: "green",
    "&:hover": {
      backgroundColor: "darkgreen",
    },
  },
  loginButton: {
    textDecoration: "none",
    color: "white",
    fontFamily: "Roboto",
    "&:hover": {
      color: "white",
      textDecoration: "none",
    },
  },
}));

export default function SignIn(props) {

  const classes = useStyles();

  let history = useHistory();
  let [user, setUser] = useState(null);
  let [password, setPassword] = useState(null);

  const verifyLogin = async () => {
    await axios.get('http://localhost:8080/login?'
      + 'user=' + user
      + '&password=' + password).then(res => {
        if (res.data) {
          props.setCurrUser(user);
          history.push("/home");
        }
      })
  }

  return (
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <div className={classes.paper}>
        <img src={Macademia} className={classes.image} />
        <Typography component="h1" variant="h5">
          Login
        </Typography>
        <TextField
          variant="outlined"
          margin="normal"
          required
          fullWidth
          id="user"
          label="Email Address"
          name="user"
          autoComplete="email"
          autoFocus
          onChange={(e) => setUser(e.target.value)} />
        <TextField
          variant="outlined" margin="normal"
          required
          fullWidth
          name="password"
          label="Password"
          type="password"
          id="password"
          autoComplete="current-password"
          onChange={(e) => setPassword(e.target.value)} />
        <Button
          type="submit"
          fullWidth
          variant="contained"
          color="primary"
          className={classes.submit}
          onClick={() => { verifyLogin() }}>
          <Typography>Login</Typography>
        </Button>
        <Grid container>
          <Grid item xs></Grid>
          <Grid item>
            <Link href="/register">{"Don't have an account? Register"}</Link>
          </Grid>
        </Grid>
      </div>
    </Container>
  );
}
