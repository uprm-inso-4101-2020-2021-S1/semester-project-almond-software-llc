import React, { useState, useEffect } from "react";
import Drawer from "@material-ui/core/Drawer";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import ExpandLess from '@material-ui/icons/ExpandLess';
import ExpandMore from '@material-ui/icons/ExpandMore';
import Collapse from '@material-ui/core/Collapse';
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
import NavigateBeforeIcon from '@material-ui/icons/NavigateBefore';
import NavigateNextIcon from '@material-ui/icons/NavigateNext';
import IconButton from '@material-ui/core/IconButton';
import axios from 'axios';

const drawerWidth = 340;

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
    backgroundColor: '#f2f2f2',
  },
  title: {
    flexGrow: 1,
  },
  drawerContainer: {
    overflow: 'auto',
  },
}));

export default function Main() {

  const classes = useStyles();

  const [myCourses, setMyCourses] = useState(null);

  const [priorities, setPriorities] = useState(null);

  const [departments, setDepartments] = useState(null);

  const [departmentCourses, setDepartmentCourses] = useState(null);

  const [matriculas, setMatriculas] = useState(null);

  let [matriculaIndex, setMatriculaIndex] = useState(0);

  let [tempCourseIndex, setCourseIndex] = useState(0);

  let [tempSourceListIndex, setSourceListIndex] = useState(0);

  let [disablePrevious, setDisablePrevious] = useState(true);

  let [disableNext, setDisableNext] = useState(false);

  let [elTicko, setElTicko] = useState(false);

  async function fetchData() {

    // const resultLogin = await axios.get('http://localhost:8080/login?user=testA&password=6969');

    const resultPriorities = await axios.get('http://localhost:8080/priority');
    setPriorities(resultPriorities.data);

    const resultDepartments = await axios.get('http://localhost:8080/departments');
    setDepartments(resultDepartments.data);

    const resultMatriculas = await axios.get('http://localhost:8080/matriculas');
    setMatriculas(resultMatriculas.data);

    // const resultMyList = await axios.get('http://localhost:8080/myList');
    // setMyCourses(resultMyList.data);

    // const resultDepartmentCourses = await axios.get('http://localhost:8080/departmentSections');
    // setDepartmentCourses(resultDepartmentCourses.data);

    // const resultMyMatriculas = await axios.get('http://localhost:8080/matriculas');
    // setMatriculas(resultMyMatriculas.data);

  }

  useEffect(() => {
    fetchData();
    console.log('updated lists');
  }, [elTicko]);

  const forceUpdate = () => {
    setElTicko(!elTicko);
  }

  const previousMatricula = () => {
    setDisablePrevious((matriculaIndex - 1) <= 0 ? true : false);
    setDisableNext(false);
    setMatriculaIndex(matriculaIndex - 1);
  }

  const nextMatricula = () => {
    setDisableNext((matriculaIndex + 1) >= (matriculas.length - 1) ? true : false);
    setDisablePrevious(false);
    setMatriculaIndex(matriculaIndex + 1);
  }

  const addCourse = (sourceListIndex, targetListIndex, courseIndex) => {
    // axios.get('http://localhost:8080/addSection?sourceListIndex=' +
    //   sourceListIndex + '&targetListIndex=' +
    //   targetListIndex + '&courseIndex=' +
    //   courseIndex + '&matriculaIndex=' +
    //   matriculaIndex)
  }

  const removeCourse = (sourceListIndex, courseIndex) => {
    // axios.get('http://localhost:8080/removeSection?sourceListIndex=' +
    //   sourceListIndex + '&courseIndex=' +
    //   courseIndex + '&matriculaIndex=' +
    //   matriculaIndex)
  }

  const onDragStart = (e, courseIndex, sourceListIndex) => {
    setCourseIndex(courseIndex);
    setSourceListIndex(sourceListIndex);
  }

  const onDragOver = (e) => {
    e.preventDefault();
  }

  const onDrop = (e, targetListIndex) => {

    let courseIndex = tempCourseIndex;
    let sourceListIndex = tempSourceListIndex;

    if (targetListIndex !== sourceListIndex) {

      // addCourse(sourceListIndex, targetListIndex, courseIndex);
      // removeCourse(sourceListIndex, courseIndex);
      forceUpdate();

    }

  }

  let [openList, setOpenList] = useState({});

  const toggleList = () => {
    setOpenList((prevState => ({ ...prevState, [id]: !prevState[id] })));
  }

  const renderDepartments = (list, title, listIndex) => {
    return <div>
      <List>
        <Typography className={classes.drawerTypography}>{title}</Typography>
        {list.map((department, i) => (
          <ListItem key={i}>
            {renderCourses(department.courses, department.name, i)}
          </ListItem>
        ))}
      </List>
    </div>
  }

  const renderCourses = (list, title, listIndex) => {
    return <div>
      <List>
        <Typography className={classes.drawerTypography}>{title}</Typography>
        {list.map((value, i) => (
          <div>
            <Typography className={classes.drawerTypography}>{value.name}: {value.courseCode}</Typography>
            <ListItem key={i}>
              {renderSections(value.sections, "", i)}
            </ListItem>
          </div>
        ))}
      </List>
    </div>

  }

  const renderSections = (list, title, listIndex) => {
    return <div onDragOver={(e) => { onDragOver(e) }} onDrop={(e) => onDrop(e, listIndex)}>
      <List>
        {list.map((value, i) => (
          <div>
            <ListItem draggable={matriculaIndex === 0} button key={i} onDragStart={(e) => onDragStart(e, i, listIndex)}>
              <Typography>{value.professor} - {value.secNum}</Typography>
              {/* <CourseCard
                courseCode={value.courseCode}
                section={value.secNum}
                courseName={value.courseName}
                professor={value.professor}
                credits={value.credits}
                color={value.color} /> */}
            </ListItem>
          </div>
        ))}
      </List>
    </div>
  }


  const renderMatricula = (list, title, listIndex) => {

    return <div onDragOver={(e) => { onDragOver(e) }} onDrop={(e) => onDrop(e, listIndex)}>
      <List>
        <Typography className={classes.drawerTypography}>{title}</Typography>
        {list.map((value, courseIndex) => (
          <ListItem draggable={matriculaIndex === 0} button key={courseIndex} onDragStart={(e) => onDragStart(e, courseIndex, listIndex)}>
            <CourseCard
              courseCode={value.courseCode}
              section={value.secNum}
              courseName={value.courseName}
              professor={value.professor}
              credits={value.credits}
              color={value.color} />
          </ListItem>
        ))}
      </List>
    </div>
  }

  return (
    <div className={classes.root}>

      <AppBar position="fixed" className={classes.appBar}>
        <Toolbar>
          <img src={Macademia} className={classes.image} />
          <Typography variant='h6' className={classes.title}>Macademia</Typography>
        </Toolbar>
      </AppBar>

      <Drawer className={classes.drawer} variant="permanent" classes={{ paper: classes.drawerPaper, }}>
        <Toolbar />
        {matriculas !== null && departments !== null ? (
          <div className={classes.drawerContainer}>
            {/* <Divider /> */}
            {renderCourses(priorities, "Priority Courses", 0)}
            <Divider />
            {/* {renderMatricula(departmentCourses, "Department Courses", 1)} */}
            {renderDepartments(departments, "Departments", 1)}
          </div>) : (<div />)}
      </Drawer>

      <main className={classes.content} style={{ height: '100vh' }}>

        <Toolbar />

        <div className={classes.centerContent}>

          <div style={{ display: 'flex', alignItems: 'center', padding: '50px' }}>
            <IconButton disabled={disableNext} onClick={() => nextMatricula()}>
              <NavigateBeforeIcon style={{ height: '50px', width: '50px' }} />
            </IconButton>
          </div>

          <Card elevation={3} style={{ width: '70%' }}>
            {matriculas !== null ? (
              <CardContent>

                <Grid item style={{ textAlign: 'center' }}>
                  <Typography style={{ fontSize: '30px' }}>{matriculas[matriculaIndex].period.semesterAsString} {matriculas[matriculaIndex].period.matyear}</Typography>
                </Grid>

                <Divider />

                <Grid container diretion='column' justify='space-around' alignItems='center'>

                  <Grid item>
                    {renderMatricula(matriculas[matriculaIndex].sections, "My Matricula", 2)}
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
                        <Typography style={{ color: '#7f7f7f' }}>Total Credits: {matriculas[matriculaIndex].totalCredits}</Typography>
                      </Grid>
                    </Grid>
                  </Grid>

                </Grid>

              </CardContent>
            ) : (<div />)}
          </Card>

          <div style={{ display: 'flex', alignItems: 'center', padding: '50px' }}>
            <IconButton disabled={disablePrevious} onClick={() => previousMatricula()}>
              <NavigateNextIcon style={{ height: '50px', width: '50px' }} />
            </IconButton>
          </div>

        </div>

      </main>

    </div>
  );
}
