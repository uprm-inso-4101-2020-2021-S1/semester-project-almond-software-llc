import React, { useState } from "react";
import Macademia from "./macademia.png";
import Button from "@material-ui/core/Button";
import CssBaseline from "@material-ui/core/CssBaseline";
import TextField from "@material-ui/core/TextField";
import Link from "@material-ui/core/Link";
import Grid from "@material-ui/core/Grid";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";
import Container from "@material-ui/core/Container";
import "date-fns";
import DateFnsUtils from "@date-io/date-fns";
import {
  MuiPickersUtilsProvider,
  KeyboardDatePicker,
} from "@material-ui/pickers";

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
    marginTop: theme.spacing(3),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
    backgroundColor: "green",
    "&:hover": {
      backgroundColor: "darkgreen",
    },
  },
  registerButton: {
    textDecoration: "none",
    color: "white",
    fontFamily: "Roboto",
    "&:hover": {
      color: "white",
      textDecoration: "none",
    },
  },
}));

export default function SignUp() {
  const classes = useStyles();

  let [newUser, setNewUser] = useState({
    fullName: "",
    password: "",
    departmentCode: "",
    studentNumber: "",
  });

  let [fullName, setFullName] = useState();
  let [password, setPassword] = useState();
  let [departmentCode, setDepartmentCode] = useState();
  let [studentNumber, setStudentNumber] = useState();
  let [passwordConfirmation, setPasswordConfirmation] = useState();

  const handleSubmit = (e) => {
    e.preventDefault();
    //const {{ props: firstName }, { props:lastName }}
  };

  const handleChange = (e) => {
    if (e.target.name === "firstName") {
      setProps({
        [e.target.firstName]: e.target.onChange,
      });
    } else if (e.target.name === "lastName") {
      setProps({
        [e.target.lastName]: e.target.onChange,
      });
    }
  };

  return (
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <div className={classes.paper}>
        <img src={Macademia} className={classes.image} />
        <Typography component="h1" variant="h5">
          Register
        </Typography>

        {/* <form className={classes.form}> */}
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField
                name="fullName"
                variant="outlined"
                required
                fullWidth
                id="fullName"
                label="Full Name"
                onChange={(e) => {
                  setFullName(e.target.value);
                }}
              />
            </Grid>

            <Grid item xs={12} sm={6}>
              <TextField
                variant="outlined"
                required
                name="studentNumber"
                label="Student Number"
                id="student-number"
                onChange={(e) => {
                  setStudentNumber(e.target.value);
                }}
              />
            </Grid>

            <Grid item xs={12} sm={6}>
              <TextField
                name="departmentCode"
                variant="outlined"
                required
                id="departmentCode"
                label="Department Code"
                onChange={(e) => {
                  setDepartmentCode(e.target.value);
                }}
              />
            </Grid>

            <Grid item xs={12}>
              <TextField
                variant="outlined"
                required
                fullWidth
                name="password"
                label="Password"
                type="password"
                id="password"
                autoComplete="current-password"
                onChange={(e) => {
                  setPassword(e.target.value);
                }}
              />
            </Grid>

            <Grid item xs={12}>
              <TextField
                variant="outlined"
                required
                fullWidth
                name="password confirmation"
                label="Password confirmation"
                type="password"
                id="password-confirmation"
                onChange={(e) => {
                  setPasswordConfirmation(e.target.value);
                }}
              />
            </Grid>
          </Grid>
          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
            className={classes.submit}
            onClick={() => {
              setNewUser({
                fullName: fullName,
                password: password,
                departmentCode: departmentCode,
                studentNumber: studentNumber,
              });
              console.log(fullName);
              console.log(password);
              console.log(departmentCode);
              console.log(studentNumber);
            }}
          >
            <Typography>Register</Typography>
          </Button>

          <Grid container justify="flex-end">
            <Grid item>
              <Link href="/">{"Already have an account? Login"}</Link>
            </Grid>
          </Grid>
        {/* </form> */}
      </div>
    </Container>
  );
}
