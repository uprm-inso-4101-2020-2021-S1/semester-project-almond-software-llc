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
  const [selectedDate, handleDateChange] = useState(new Date());
  
  let [props, setProps] = useState(
    {
      firstName: "",
      lastName: "",
      email: "",
      password: "",
      passwordConfirmation: "",
      ssn: "",
      birthdate: "",
      pin: "",
      studentNumber: "",
      registrationErrors: "",
    },
  );

  //let [setRe] = useState({});

  const handleSubmit = (e) =>{
    e.preventDefault();
  }

  const handleChange = (e) => {
    setProps({
      [e.target.firstName]: e.target.value
    });
    
  }

  // const onChange = (e) => {
  //   const re = /^[A-Za-z]+$/;
  //   if (e.target.value === '' || re.test(e.target.value)) {
  //     setRe({
  //       value: e.target.value
  //     });
  //   }
  // }
  //this.handleSubmit = this.handleSubmit.bind(this);

  return (
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <div className={classes.paper}>
        <img src={Macademia} className={classes.image} />
        <Typography component="h1" variant="h5">
          Register
        </Typography>

        <form className={classes.form} onSubmit={handleSubmit}>
          <Grid container spacing={2}>
            <Grid item xs={12} sm={6}>
              <TextField
                autoComplete="fname"
                name="firstName"
                variant="outlined"
                required
                fullWidth
                id="firstName"
                label="First Name"
                autoFocus
                value={props.firstName}
                //onChange={onChange}
              />
            </Grid>

            <Grid item xs={12} sm={6}>
              <TextField
                variant="outlined"
                required
                fullWidth
                id="lastName"
                label="Last Name"
                name="lastName"
                autoComplete="lname"
                value={props.lastName}
              />
            </Grid>

            <Grid item xs={12} sm={6}>
              <TextField
                variant="outlined"
                required
                fullWidth
                name="ssn"
                label="SSN"
                id="password"
                value={props.ssn}
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                variant="outlined"
                required
                fullWidth
                name="Pin Number"
                label="Pin Number"
                type="password"
                id="pin-number"
                value={props.pin}
              />
            </Grid>

            <Grid item xs={12}>
              <TextField
                variant="outlined"
                required
                fullWidth
                name="student-number"
                label="Student Number"
                id="student-number"
                value={props.studentNumber}
              />
            </Grid>

            <MuiPickersUtilsProvider utils={DateFnsUtils}>
              <Grid item xs={12}>
                <KeyboardDatePicker
                  autoOk
                  required
                  fullWidth
                  clearable
                  variant="inline"
                  inputVariant="outlined"
                  label="Birth date"
                  format="MM/dd/yyyy"
                  placeholder="10/10/2018"
                  value={(selectedDate, props.birthdate)}
                  onChange={(date) => handleDateChange(date)}
                  minDate={new Date()}
                />
              </Grid>
            </MuiPickersUtilsProvider>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                required
                fullWidth
                id="email"
                label="Email Address"
                name="email"
                autoComplete="email"
                value={props.email}
                onChange={handleChange}
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
                value={props.password}
                onChange={handleChange}
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
                id="password"
                value={props.passwordConfirmation}
                onChange={handleChange}
              />
            </Grid>
          </Grid>
          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
            className={classes.submit}
          >
            <Link href="/" className={classes.registerButton}>
              Register
            </Link>
          </Button>
          <Grid container justify="flex-end">
            <Grid item>
              <Link href="/">{"Already have an account? Login"}</Link>
            </Grid>
          </Grid>
        </form>
      </div>
    </Container>
  );
}
