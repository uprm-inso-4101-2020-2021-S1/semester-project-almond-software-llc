import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";
import Divider from "@material-ui/core/Divider";
import Grid from "@material-ui/core/Grid";
import CourseCard from "../CourseCard/coursecard";

const useStyles = makeStyles((theme) => ({
  root: {
    minWidth: 275,
    width: "100%",
    backgroundColor: "green",
    boxShadow: "10px 10px 10px #999999",
  },
  bullet: {
    display: "inline-block",
    margin: "0 2px",
    transform: "scale(0.8)",
  },
  title: {
    fontSize: "0.5rem",
    display: "inline-block",
    paddingLeft: "4rem",
    color: "white",
    fontFamily: "'Roboto', sans-serif",
  },
  pos: {
    marginBottom: 12,
  },
  content: {
    flexGrow: 1,
    padding: theme.spacing(3),
    paddingLeft: theme.spacing(45),
  },
  cardGrid: {
    backgroundColor: "#f2f2f2",
  },
}));

export default function Matricula() {
  const classes = useStyles();
  const firstSemester = "First Semester";
  const secondSemester = "Second Semester";

  return (
    <main className={classes.content}>
      <div className={classes.toolbar} />
      <Card className={classes.root}>
        <CardContent>
          <Typography
            className={classes.title}
            color="textSecondary"
            gutterBottom
          >
            {firstSemester}
          </Typography>
          <Typography
            className={classes.title}
            color="textSecondary"
            gutterBottom
          >
            {secondSemester}
          </Typography>

          <Divider />
          <Grid
            container
            direction="row"
            justify="space-around"
            alignItems="center"
            style={{ padding: "10px" }}
            className={classes.cardGrid}
          >
            <div>
              <div style={{ padding: "10px" }}>
                <CourseCard style={{ boxShadow: "10px 10px 10px #999999" }} />
              </div>
              <div style={{ padding: "10px" }}>
                <CourseCard style={{ boxShadow: "10px 10px 10px #999999" }} />
              </div>
              <div style={{ padding: "10px" }}>
                <CourseCard style={{ boxShadow: "10px 10px 10px #999999" }} />
              </div>
              <div style={{ padding: "10px" }}>
                <CourseCard style={{ boxShadow: "10px 10px 10px #999999" }} />
              </div>
            </div>

            <Divider orientation="vertical" flexItem />

            <div>
              <div style={{ padding: "10px" }}>
                <CourseCard style={{ boxShadow: "5px 5px 5px #999999" }} />
              </div>
              <div style={{ padding: "10px" }}>
                <CourseCard style={{ boxShadow: "5px 5px 5px #999999" }} />
              </div>
              <div style={{ padding: "10px" }}>
                <CourseCard style={{ boxShadow: "5px 5px 5px #999999" }} />
              </div>
              <div style={{ padding: "10px"}}>
                <CourseCard style={{ boxShadow: "5px 5px 5px #999999" }} />
              </div>
            </div>
          </Grid>
        </CardContent>
      </Card>
    </main>
  );
}
