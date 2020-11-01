import React, { useState } from "react";
import Drawer from "@material-ui/core/Drawer";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import List from "@material-ui/core/List";
import Divider from "@material-ui/core/Divider";
import ListItem from "@material-ui/core/ListItem";
import CourseCard from "../coursecard/CourseCard.js";
import Macademia from "./macademia.png";
import { makeStyles } from "@material-ui/core/styles";
import { Typography } from "@material-ui/core";
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Grid from '@material-ui/core/Grid';
import Button from '@material-ui/core/Button';

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
    width: `calc(100% - ${drawerWidth}px)`,
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
    },
  ]);

  let [myMatricula, setMyMatricula] = useState([
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
    },
  ])

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
      },
    ],
  }

  const forceUpdate = () => setElTicko(!elTicko);

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
        myMatricula.forEach(value => {
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
          myMatricula.push(course);
        }
        setTotalCredits(totalCredits + course.credits);
        break;

      default:
        console.log("INVALID");
        break;

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
        myMatricula.forEach((value, i) => {
          if (value.courseCode === course.courseCode) {
            myMatricula.splice(i, 1);
          }
        });
        setTotalCredits(totalCredits - course.credits);
        break;

      default:
        console.log("INVALID");
        break;

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

    if (list != course.list) {

      addCourse(list, course);

      removeCourse(e_list, course);

      forceUpdate();

    }

    console.log('=====================================');
    console.log('myCourses: ' + myCourses.length + ', ' + myCourses);
    console.log('departmentCourses: ' + departmentCourses.length + ', ' + departmentCourses);
    console.log('myMatricula: ' + myMatricula.length + ', ' + myMatricula);
    console.log('=====================================');

  }

  return (
    <div className={classes.root}>

      <AppBar position="fixed" className={classes.appBar}>
        <Toolbar>
          <img src={Macademia} className={classes.image} />
          <div className={classes.grow} />
        </Toolbar>
      </AppBar>

      <Drawer className={classes.drawer} variant="permanent" classes={{ paper: classes.drawerPaper, }} anchor="left">
        <div className={classes.toolbar} />

        <Divider />

        <div onDragOver={(e) => { onDragOver(e) }} onDrop={(e) => onDrop(e, 0)}>
          <List>
            <Typography className={classes.drawerTypography}>My Courses</Typography>
            {myCourses.map((value, i) => (
              <ListItem draggable button key={i} onDragStart={(e) => onDragStart(e, value)}>
                <CourseCard
                  courseCode={value.courseCode}
                  section={value.section}
                  courseName={value.courseName}
                  professor={value.professor}
                  credits={value.credits}
                  color={value.color} />
              </ListItem>
            ))}
          </List>
        </div>

        <Divider />

        <div onDragOver={(e) => { onDragOver(e) }} onDrop={(e) => onDrop(e, 1)}>
          <List>
            <Typography className={classes.drawerTypography}>Department of INSO</Typography>
            {departmentCourses.map((value, i) => (
              <ListItem draggable button key={i} onDragStart={(e) => onDragStart(e, value)}>
                <CourseCard
                  courseCode={value.courseCode}
                  section={value.section}
                  courseName={value.courseName}
                  professor={value.professor}
                  credits={value.credits}
                  color={value.color} />
              </ListItem>
            ))}
          </List>
        </div>

      </Drawer>

      <main className={classes.content}>
        <div className={classes.toolbar} />
        <div className={classes.centerContent}>

          <Card elevation={3} style={{ width: '70%' }}>
            <CardContent>

              <Grid item style={{ textAlign: 'center' }}>
                <Typography style={{ fontSize: '30px' }}>2020</Typography>
              </Grid>

              <Divider />

              <Grid container diretion='column' justify='space-around' alignItems='center'>

                <Grid item>
                  {myMatricula.length === 0 ? (
                    <div onDragOver={(e) => { onDragOver(e) }} onDrop={(e) => onDrop(e, 2)} style={{ height: '100px', width: '100px' }} />
                  ) : (
                      <div onDragOver={(e) => { onDragOver(e) }} onDrop={(e) => onDrop(e, 2)} style={{}}>
                        <List>
                          {myMatricula.map((value, i) => (
                            <ListItem draggable button key={i} onDragStart={(e) => onDragStart(e, value)}>
                              <CourseCard
                                courseCode={value.courseCode}
                                section={value.section}
                                courseName={value.courseName}
                                professor={value.professor}
                                credits={value.credits}
                                color={value.color} />
                            </ListItem>
                          ))}
                        </List>
                      </div>
                    )}
                </Grid>

                <Grid item>
                  <Grid container direction='column' justify='space-around' alignItems='center' spacing={3}>
                    <Grid item>
                      <Button>Add Section</Button>
                    </Grid>
                    <Grid item>
                      <Button>Remove Section</Button>
                    </Grid>
                    <Grid item>
                      <Button>View Schedule</Button>
                    </Grid>
                    <Grid item>
                      <Typography style={{ color: '#7f7f7f' }}>Total Credits: {totalCredits}</Typography>
                    </Grid>
                  </Grid>
                </Grid>

              </Grid>

            </CardContent>
          </Card>

        </div>
      </main>
    </div>
  );
}
