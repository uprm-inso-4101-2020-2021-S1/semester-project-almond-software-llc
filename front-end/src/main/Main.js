import React, { useState } from "react";
import Drawer from "@material-ui/core/Drawer";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import List from "@material-ui/core/List";
import Divider from "@material-ui/core/Divider";
import ListItem from "@material-ui/core/ListItem";
import CourseCard from "../sectioncard/SectionCard.js";
import Macademia from "./macademia.png";
import { makeStyles } from "@material-ui/core/styles";
import { Typography } from "@material-ui/core";
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Grid from '@material-ui/core/Grid';
import Button from '@material-ui/core/Button';
import NavigateBeforeIcon from '@material-ui/icons/NavigateBefore';
import NavigateNextIcon from '@material-ui/icons/NavigateNext';
import IconButton from '@material-ui/core/IconButton';
import ScheduleCard from "../schedulecard/ScheduleCard.js";

const drawerWidth = 240;

const useStyles = makeStyles((theme) => ({
  grow: {
    flexGrow: 1,
  },
  image: {
    width: 60,
    height: 60,
  },
  root: {
    display: "flex",
    flexGrow: 1,
  },
  appBar: {
    zIndex: theme.zIndex.drawer + 1,
    // width: `calc(100% - ${drawerWidth}px)`,
    marginLeft: drawerWidth,
    backgroundColor: "green",
  },
  drawer: {
    width: drawerWidth,
    flexShrink: 0,
  },
  drawerPaper: {
    width: drawerWidth,
  },
  drawerTypography: {
    color: "black",
    textAlign: "center",
    // textShadow: "1px 1px 2px green",
    fontFamily: "Roboto",
  },
  cardLists: {
    alignContent: "center",
    display: "block",
    justifyContent: "center",
  },
  centerContent: {
    alignContent: "center",
    display: "flex",
    justifyContent: "center",
  },
  // necessary for content to be below app bar
  toolbar: theme.mixins.toolbar,
  content: {
    flexGrow: 1,
    // backgroundColor: theme.palette.background.default,
    padding: theme.spacing(3),
    backgroundColor: "#f2f2f2",
  },
  title: {
    flexGrow: 1,
  },
  drawerContainer: {
    overflow: "auto",
  },
  loginButton: {
    fontFamily: "Roboto",
    fontWeight: 700,
    marginRight: "3rem",
    "&:hover": {
      background: "darkgreen",
    },
  },
  registerButton: {
    fontFamily: "Roboto",
    fontWeight: 700,
    "&:hover": {
      background: "darkgreen",
    },
  },
}));

export default function Main() {

  const classes = useStyles();

  // let [tempCourse, setTempCourse] = useState({})

  let [myCourses, setMyCourses] = useState([
    {
      section: '001',
      day: 'LWV',
      time: '12:00pm',
      professor: 'Dr. Test',
      building: 'T',
      room: '401',
      courseName: 'Test Course 1',
      courseCode: 'TEST3001',
      capacity: 15,
      population: 0,
      credits: 3,
      color: 'purple',
      list: 0,
      availability: 'First and Second',
      description: 'This is a test description.'
    },
    {
      section: '002',
      day: 'LWV',
      time: '12:00pm',
      professor: 'Dr. Test',
      building: 'T',
      room: '402',
      courseName: 'Test Course 2',
      courseCode: 'TEST3002',
      capacity: 15,
      population: 0,
      credits: 3,
      color: 'purple',
      list: 0,
      availability: 'First and Second',
      description: 'I must not fear. Fear is the mind-killer. Fear is the little-death that brings total obliteration. I will face my fear. I will permit it to pass over me and through me. And when it has gone past I will turn the inner eye to see its path. Where the fear has gone there will be nothing. Only I will remain.'
    },
    {
      section: '003',
      day: 'LWV',
      time: '12:00pm',
      professor: 'Dr. Test',
      building: 'T',
      room: '403',
      courseName: 'Test Course 3',
      courseCode: 'TEST3003',
      capacity: 15,
      population: 0,
      credits: 3,
      color: 'purple',
      list: 0,
      availability: 'First and Second',
      description: 'This is a test description.'
    },
    {
      section: '004',
      day: 'LWV',
      time: '12:00pm',
      professor: 'Dr. Test',
      building: 'T',
      room: '404',
      courseName: 'Test Course 4',
      courseCode: 'TEST3004',
      capacity: 15,
      population: 0,
      credits: 3,
      color: 'purple',
      list: 0,
      availability: 'First and Second',
      description: 'This is a test description.'
    },
  ]);

  let [departmentCourses, setDepartmentCourses] = useState([
    {
      section: '005',
      day: 'LWV',
      time: '12:00pm',
      professor: 'Dr. Test',
      building: 'T',
      room: '401',
      courseName: 'Test Course 5',
      courseCode: 'TEST4005',
      capacity: 15,
      population: 0,
      credits: 3,
      color: 'green',
      list: 1,
      availability: 'First and Second',
      description: 'This is a test description.'
    },
    {
      section: '006',
      day: 'LWV',
      time: '12:00pm',
      professor: 'Dr. Test',
      building: 'T',
      room: '402',
      courseName: 'Test Course 6',
      courseCode: 'TEST4006',
      capacity: 15,
      population: 0,
      credits: 3,
      color: 'green',
      list: 1,
      availability: 'First and Second',
      description: 'This is a test description.'
    },
    {
      section: '007',
      day: 'LWV',
      time: '12:00pm',
      professor: 'Dr. Test',
      building: 'T',
      room: '403',
      courseName: 'Test Course 7',
      courseCode: 'TEST4007',
      capacity: 15,
      population: 0,
      credits: 3,
      color: 'green',
      list: 1,
      availability: 'First and Second',
      description: 'This is a test description.'
    },
    {
      section: '008',
      day: 'LWV',
      time: '12:00pm',
      professor: 'Dr. Test',
      building: 'T',
      room: '408',
      courseName: 'Test Course 8',
      courseCode: 'TEST4008',
      capacity: 15,
      population: 0,
      credits: 3,
      color: 'green',
      list: 1,
      availability: 'First and Second',
      description: 'This is a test description.'
    },
  ]);

  let [matriculaIndex, setMatriculaIndex] = useState(0);

  let [disablePrevious, setDisablePrevious] = useState(true);

  let [disableNext, setDisableNext] = useState(false);

  let matriculaA = {
    period: '2020',
    totalCredits: 12,
    data: [
      {
        section: '005',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '401',
        courseName: 'Test Course 5',
        courseCode: 'TEST1005',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'blue',
        list: 2,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
      {
        section: '006',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '402',
        courseName: 'Test Course 6',
        courseCode: 'TEST1006',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'blue',
        list: 2,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
      {
        section: '007',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '403',
        courseName: 'Test Course 7',
        courseCode: 'TEST1007',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'blue',
        list: 2,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
      {
        section: '008',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '408',
        courseName: 'Test Course 8',
        courseCode: 'TEST1008',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'blue',
        list: 2,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
    ]
  };

  let matriculaB = {
    period: '2021',
    totalCredits: 12,
    data: [
      {
        section: '005',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '401',
        courseName: 'Test Course 5',
        courseCode: 'TEST2005',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'red',
        list: 2,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
      {
        section: '006',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '402',
        courseName: 'Test Course 6',
        courseCode: 'TEST2006',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'red',
        list: 2,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
      {
        section: '007',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '403',
        courseName: 'Test Course 7',
        courseCode: 'TEST2007',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'red',
        list: 2,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
      {
        section: '008',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '408',
        courseName: 'Test Course 8',
        courseCode: 'TEST2008',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'red',
        list: 2,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
    ]
  };

  let matriculaC = {
    period: '2022',
    totalCredits: 12,
    data: [
      {
        section: '005',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '401',
        courseName: 'Test Course 5',
        courseCode: 'TEST3005',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'yellow',
        list: 2,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
      {
        section: '006',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '402',
        courseName: 'Test Course 6',
        courseCode: 'TEST3006',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'yellow',
        list: 2,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
      {
        section: '007',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '403',
        courseName: 'Test Course 7',
        courseCode: 'TEST3007',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'yellow',
        list: 2,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
      {
        section: '008',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '408',
        courseName: 'Test Course 8',
        courseCode: 'TEST3008',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'yellow',
        list: 2,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
    ]
  };

  let [myMatriculas, setMyMatriculas] = useState([matriculaA, matriculaB, matriculaC]);

  let [totalCredits, setTotalCredits] = useState(12);

  let [elTicko, setElTicko] = useState(false);

  let tempCourse = {};

  let lists = {
    myCourses: [
      {
        section: '001',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '401',
        courseName: 'Test Course 1',
        courseCode: 'TEST3001',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'purple',
        list: 0,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
      {
        section: '002',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '402',
        courseName: 'Test Course 2',
        courseCode: 'TEST3002',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'purple',
        list: 0,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
      {
        section: '003',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '403',
        courseName: 'Test Course 3',
        courseCode: 'TEST3003',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'purple',
        list: 0,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
      {
        section: '004',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '404',
        courseName: 'Test Course 4',
        courseCode: 'TEST3004',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'purple',
        list: 0,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
    ],
    departmentCourses: [
      {
        section: '005',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '401',
        courseName: 'Test Course 5',
        courseCode: 'TEST4005',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'green',
        list: 1,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
      {
        section: '006',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '402',
        courseName: 'Test Course 6',
        courseCode: 'TEST4006',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'green',
        list: 1,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
      {
        section: '007',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '403',
        courseName: 'Test Course 7',
        courseCode: 'TEST4007',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'green',
        list: 1,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
      {
        section: '008',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '408',
        courseName: 'Test Course 8',
        courseCode: 'TEST4008',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'green',
        list: 1,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
    ],
    myMatricula: [
      {
        section: '005',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '401',
        courseName: 'Test Course 5',
        courseCode: 'TEST6005',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'blue',
        list: 2,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
      {
        section: '006',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '402',
        courseName: 'Test Course 6',
        courseCode: 'TEST6006',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'blue',
        list: 2,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
      {
        section: '007',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '403',
        courseName: 'Test Course 7',
        courseCode: 'TEST6007',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'blue',
        list: 2,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
      {
        section: '008',
        day: 'LWV',
        time: '12:00pm',
        professor: 'Dr. Test',
        building: 'T',
        room: '408',
        courseName: 'Test Course 8',
        courseCode: 'TEST6008',
        capacity: 15,
        population: 0,
        credits: 3,
        color: 'blue',
        list: 2,
        availability: 'First and Second',
        description: 'This is a test description.'
      },
    ],
  }

  const forceUpdate = () => {
    setElTicko(!elTicko);
  }

  const previousMatricula = () => {
    setDisablePrevious((matriculaIndex - 1) <= 0 ? true : false);
    setDisableNext(false);
    setMatriculaIndex(matriculaIndex - 1);
  }

  const nextMatricula = () => {
    setDisableNext((matriculaIndex + 1) >= (myMatriculas.length - 1) ? true : false);
    setDisablePrevious(false);
    setMatriculaIndex(matriculaIndex + 1);
  }

  const verifyCourse = (list, course) => {

    switch (list) {

      case 0:
        myCourses.forEach(value => {
          if (value.courseCode === course.courseCode) {
            return false;
          }
        });
        return true;

      case 1:
        departmentCourses.forEach(value => {
          if (value.courseCode === course.courseCode) {
            return false;
          }
        });
        return true;

      case 2:
        myMatriculas[matriculaIndex].data.forEach(value => {
          if (value.courseCode === course.courseCode) {
            return false;
          }
        });
        return true;

      default:
        console.log("INVALID");
        return false;

    }

  }

  const addCourse = (list, course) => {

    switch (list) {

      case 0:
        if (verifyCourse(list, course)) {
          myCourses.push(course);
        }
        break;

      case 1:
        if (verifyCourse(list, course)) {
          departmentCourses.push(course);
        }
        break;

      case 2:
        if (verifyCourse(list, course)) {
          return myMatriculas[matriculaIndex].data.push(course);
        }
        // myMatriculas[matriculaIndex].totalCredits + course.credits;
        break;

      // default:
      //   console.log("INVALID");
      //   break;

    }

  }

  const removeCourse = (e_list, course) => {

    switch (e_list) {

      case 0:
        myCourses.forEach((value, i) => {
          if (value.courseCode === course.courseCode) {
            myCourses.splice(i, 1);
          }
        });
        break;

      case 1:
        departmentCourses.forEach((value, i) => {
          if (value.courseCode === course.courseCode) {
            departmentCourses.splice(i, 1);
          }
        });
        break;

      case 2:
        myMatriculas[matriculaIndex].data.forEach((value, i) => {
          if (value.courseCode === course.courseCode) {
            return myMatriculas[matriculaIndex].data.splice(i, 1);
          }
        });
        // myMatriculas[matriculaIndex].totalCredits - course.credits;
        break;

      // default:
      //   console.log("INVALID");
      //   break;

    }

  }

  const onDragStart = (e, course) => {
    e.dataTransfer.setData('list', course.list);
    tempCourse = course;
  }

  const onDragOver = (e) => {
    e.preventDefault();
  }

  const onDrop = (e, list) => {

    let course = tempCourse;
    let e_list = tempCourse.list;

    if (list !== course.list) {

      addCourse(list, course);

      removeCourse(e_list, course);

      forceUpdate();

    }

    console.log('=====================================');
    console.log('myCourses: ' + myCourses.length + ', ' + myCourses);
    console.log('departmentCourses: ' + departmentCourses.length + ', ' + departmentCourses);
    console.log('myMatricula: ' + myMatriculas[matriculaIndex].data.length + ', ' + myMatriculas[matriculaIndex].data);
    console.log('=====================================');

  }

  return (
    <div className={classes.root}>
      <AppBar position="fixed" className={classes.appBar}>
        <Toolbar>
          <img src={Macademia} className={classes.image} />
          <Typography variant="h6" className={classes.title}>
            Macademia
          </Typography>

          <Button color="inherit" className={classes.loginButton}>Login</Button>
          <Button color="inherit" className={classes.registerButton}>Register</Button>
        </Toolbar>
      </AppBar>

      <Drawer
        className={classes.drawer}
        variant="permanent"
        classes={{ paper: classes.drawerPaper }}
      >
        <Toolbar />

        <div className={classes.drawerContainer}>
          <Divider />

          <div
            onDragOver={(e) => {
              onDragOver(e);
            }}
            onDrop={(e) => onDrop(e, 0)}
          >
            <List>
              <Typography className={classes.drawerTypography}>
                My Courses
              </Typography>
              {myCourses.map((value, i) => (
                <ListItem
                  draggable
                  button
                  key={i}
                  onDragStart={(e) => onDragStart(e, value)}
                >
                  <CourseCard
                    courseCode={value.courseCode}
                    section={value.section}
                    courseName={value.courseName}
                    professor={value.professor}
                    credits={value.credits}
                    color={value.color}
                    capacity={value.capacity}
                    population={value.population}
                    availability={value.availability}
                    description={value.description}
                    time={value.time} />
                </ListItem>
              ))}
            </List>
          </div>

          <Divider />

          <div
            onDragOver={(e) => {
              onDragOver(e);
            }}
            onDrop={(e) => onDrop(e, 1)}
          >
            <List>
              <Typography className={classes.drawerTypography}>
                Department of INSO
              </Typography>
              {departmentCourses.map((value, i) => (
                <ListItem
                  draggable
                  button
                  key={i}
                  onDragStart={(e) => onDragStart(e, value)}
                >
                  <CourseCard
                    courseCode={value.courseCode}
                    section={value.section}
                    courseName={value.courseName}
                    professor={value.professor}
                    credits={value.credits}
                    color={value.color}
                    capacity={value.capacity}
                    population={value.population}
                    availability={value.availability}
                    description={value.description}
                    time={value.time} />
                </ListItem>
              ))}
            </List>
          </div>
        </div>
      </Drawer>

      <main className={classes.content} style={{ height: "100vh" }}>
        <Toolbar />

        <div className={classes.centerContent}>
          <div
            style={{ display: "flex", alignItems: "center", padding: "50px" }}
          >
            <IconButton
              disabled={disablePrevious}
              onClick={() => previousMatricula()}
            >
              <NavigateBeforeIcon style={{ height: "50px", width: "50px" }} />
            </IconButton>
          </div>

          <Card elevation={3} style={{ width: "70%" }}>
            <CardContent>
              <Grid item style={{ textAlign: "center" }}>
                <Typography style={{ fontSize: "30px" }}>
                  {myMatriculas[matriculaIndex].period}
                </Typography>
              </Grid>

              <Divider />

              <Grid
                container
                diretion="column"
                justify="space-around"
                alignItems="center"
              >
                <Grid item>
                  {myMatriculas[matriculaIndex].data.length === 0 ? (
                    <div
                      onDragOver={(e) => {
                        onDragOver(e);
                      }}
                      onDrop={(e) => onDrop(e, 2)}
                      style={{ height: "100px", width: "100px" }}
                    />
                  ) : (
                      <div onDragOver={(e) => { onDragOver(e) }} onDrop={(e) => onDrop(e, 2)} style={{}}>
                        <List>
                          {myMatriculas[matriculaIndex].data.map((value, i) => (
                            <ListItem draggable button key={i} onDragStart={(e) => onDragStart(e, value)}>
                              <CourseCard
                                courseCode={value.courseCode}
                                section={value.section}
                                courseName={value.courseName}
                                professor={value.professor}
                                credits={value.credits}
                                color={value.color}
                                capacity={value.capacity}
                                population={value.population}
                                availability={value.availability}
                                description={value.description}
                                time={value.time} />
                            </ListItem>
                          ))}
                        </List>
                      </div>
                    )}
                </Grid>
                
                <Grid item>
                  <Grid container direction='column' justify='space-around' alignItems='center' spacing={3}>

                    <Grid item>
                      <ScheduleCard />
                    </Grid>

                    <Grid item>
                      <Typography style={{ color: "#7f7f7f" }}>
                        Total Credits:{" "}
                        {myMatriculas[matriculaIndex].totalCredits}
                      </Typography>
                    </Grid>

                  </Grid>
                </Grid>
                
              </Grid>
            </CardContent>
          </Card>

          <div
            style={{ display: "flex", alignItems: "center", padding: "50px" }}
          >
            <IconButton disabled={disableNext} onClick={() => nextMatricula()}>
              <NavigateNextIcon style={{ height: "50px", width: "50px" }} />
            </IconButton>
          </div>
        </div>
      </main>
    </div>
  );
}
