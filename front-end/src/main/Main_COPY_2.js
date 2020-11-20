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

const drawerWidth = 270;

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

  const [priorities, setPriorities] = useState(null);

  const [departments, setDepartments] = useState(null);

  const [matriculas, setMatriculas] = useState(null);

  const [isCourseSection, setIsCourseSection] = useState(0); //0 = course, 1 = section

  let [priorityCourseIndex, setPriorityCourseIndex] = useState(0);

  let [departmentIndex, setDepartmentIndex] = useState(0);

  let [matriculaIndex, setMatriculaIndex] = useState(0);

  let [tempValueIndex, setValueIndex] = useState(0);

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

  }

  useEffect(() => {
    fetchData();
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

  const addCourse = (sourceListIndex, targetListIndex, valueIndex, departmentIndex, matriculaIndex) => {
  }

  const removeCourse = (sourceListIndex, courseIndex) => {
  }

  const addSection = (sourceListIndex, targetListIndex, valueIndex, priorityCourseIndex, matriculaIndex) => {
  }

  const removeSection = (sourceListIndex, courseIndex) => {
  }

  const listCourseSwitch = (listIndex, departmentIndex) => {
    switch (listIndex) {
      case 0:
        return priorities;
      case 1:
        return departments[departmentIndex].courses;
      default:
        console.log('INVALID');
    }
  }

  const listSectionSwitch = (listIndex, courseIndex) => {
    switch (listIndex) {
      case 0:
        return priorities[courseIndex].sections;
      case 1:
        return matriculas[matriculaIndex].sections;
      default:
        console.log('INVALID');
    }
  }

  const listNameSwitch = (listType, listIndex) => {
    if (listIndex === 0) {
      return 'from: priority courses';
    } else {
      if (listType === 0) {
        return 'from: department courses';
      } else {
        return 'from: matricula sections';
      }
    }
  }

  const onDragOver = (e) => {
    e.preventDefault();
  }

  const onDragStart = (e, listType, valueIndex, sourceListIndex, mainListIndex) => {

    if (listType === 0) {
      console.log('list type: course');
      console.log(listCourseSwitch(sourceListIndex, mainListIndex)[valueIndex]);
      console.log(listNameSwitch(listType, sourceListIndex));
    } else {
      console.log('list type: section');
      console.log(listSectionSwitch(sourceListIndex, mainListIndex)[valueIndex])
      console.log(listNameSwitch(listType, sourceListIndex));
    }

    setIsCourseSection(listType)
    setValueIndex(valueIndex);
    setSourceListIndex(sourceListIndex);

    if (listType === 0) {
      setPriorityCourseIndex(mainListIndex);
    } else {
      setDepartmentIndex(mainListIndex);
    }

  }

  const onDrop = (e, targetListIndex) => {

    let valueIndex = tempValueIndex;
    let sourceListIndex = tempSourceListIndex;

    if (targetListIndex !== sourceListIndex) {

      switch (isCourseSection) {
        case 0:
          addCourse(sourceListIndex, targetListIndex, valueIndex, departmentIndex, matriculaIndex);
          removeCourse();
          break;
        case 1:
          addSection(sourceListIndex, targetListIndex, valueIndex, priorityCourseIndex, matriculaIndex);
          removeSection();
          break;
        default:
          console.log('INVALID');
      }

      forceUpdate();

    }

  }

  const renderDepartments = (departmentsList, title, listIndex) => {
    return <div onDragOver={(e) => { onDragOver(e) }} onDrop={(e) => onDrop(e, listIndex)}>
      <List>
        <Typography className={classes.drawerTypography}>{title}</Typography>
        {departmentsList.map((department, departmentsIndex) => (
          <div key={departmentsIndex}>
            <ListItem>
              <Typography>{department.name}</Typography>
            </ListItem>
            <List>
              {department.courses.map((course, coursesIndex) => (
                <ListItem draggable={true} button key={coursesIndex} onDragStart={(e) => onDragStart(e, 0, coursesIndex, 1, departmentsIndex)}>
                  <Typography>{course.name}</Typography>
                </ListItem>
              ))}
            </List>
          </div>
        ))}
      </List>
    </div>
  }

  const renderPriorityCourses = (coursesList, title, listIndex) => {
    return <div onDragOver={(e) => { onDragOver(e) }} onDrop={(e) => onDrop(e, listIndex)}>
      <List>
        <Typography className={classes.drawerTypography}>{title}</Typography>
        {coursesList.map((course, coursesIndex) => (
          <div key={coursesIndex}>
            <ListItem draggable={true} button key={coursesIndex} onDragStart={(e) => onDragStart(e, 0, coursesIndex, 0, coursesIndex)}>
              <Typography className={classes.drawerTypography}>{course.name}: {course.courseCode}</Typography>
            </ListItem>
            <List>
              {course.sections.map((section, sectionsIndex) => (
                <ListItem draggable={true} button key={sectionsIndex} onDragStart={(e) => onDragStart(e, 1, sectionsIndex, 0, coursesIndex)}>
                  <Typography>{section.secNum}</Typography>
                </ListItem>
              ))}
            </List>
          </div>
        ))}
      </List>
    </div>
  }

  const renderMatricula = (matriculaList, title, listIndex) => {
    return <div onDragOver={(e) => { onDragOver(e) }} onDrop={(e) => onDrop(e, listIndex)}>
      <List>
        <Typography className={classes.drawerTypography}>{title}</Typography>
        {matriculaList.map((sections, sectionsIndex) => (
          <ListItem draggable={matriculaIndex === 0} button key={sectionsIndex} onDragStart={(e) => onDragStart(e, 1, sectionsIndex, 1, matriculaIndex)}>
            <CourseCard
              courseCode={sections.courseCode}
              section={sections.secNum}
              courseName={sections.courseName}
              professor={sections.professor}
              credits={sections.credits}
              color={sections.color} />
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
        {priorities !== null && departments !== null ? (
          <div className={classes.drawerContainer}>
            {renderPriorityCourses(priorities, "Priority Courses", 0)}
            <Divider />
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
