import React, { useState, useEffect } from "react";
import Drawer from "@material-ui/core/Drawer";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Collapse from "@material-ui/core/Collapse";
import List from "@material-ui/core/List";
import Divider from "@material-ui/core/Divider";
import ListItem from "@material-ui/core/ListItem";
import SectionCard from "../sectioncard/SectionCard";
import CourseCard from "../coursecard/coursecard.js";
import Macademia from "./macademia.png";
import { makeStyles } from "@material-ui/core/styles";
import { Typography } from "@material-ui/core";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import Grid from "@material-ui/core/Grid";
import Button from "@material-ui/core/Button";
import ScheduleCard from "../schedulecard/ScheduleCard.js";
import NavigateBeforeIcon from "@material-ui/icons/NavigateBefore";
import NavigateNextIcon from "@material-ui/icons/NavigateNext";
import IconButton from "@material-ui/core/IconButton";
import axios from "axios";
import DeleteForeverIcon from '@material-ui/icons/DeleteForever';
import { BrowserRouter as Router, useHistory } from "react-router-dom";
import Cookies from 'js-cookie';
import MacademiaTitle from './Macademia_title.png';

const drawerWidth = 270;

const useStyles = makeStyles((theme) => ({
  grow: {
    flexGrow: 1,
  },
  image: {
    width: '15rem',
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
    backgroundColor: "#1e8449",
    display: 'flex',
    justifyContent: 'space-between',
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
    padding: '10px',
    //fontWeight:'700',
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
  logoutButton: {
    textDecoration: "none",
    color: "white",
    fontFamily: "Roboto",
    "&:hover": {
      color: "white",
      textDecoration: "none",
    },
  },
}));

export default function Main() {

  const classes = useStyles();

  let history = useHistory();

  const [priorities, setPriorities] = useState(null);

  const [departments, setDepartments] = useState(null);

  const [matriculas, setMatriculas] = useState(null);

  const [isCourseSection, setIsCourseSection] = useState(0); //0 = course, 1 = section

  let [courseExpands, setCourseExpands] = useState({ [0]: false });

  let [priorityCourseIndex, setPriorityCourseIndex] = useState(0);

  let [departmentIndex, setDepartmentIndex] = useState(0);

  let [matriculaIndex, setMatriculaIndex] = useState(0);

  let [tempValueIndex, setValueIndex] = useState(0);

  let [tempSourceListIndex, setSourceListIndex] = useState(0);

  let [disablePrevious, setDisablePrevious] = useState(true);

  let [disableNext, setDisableNext] = useState(false);

  let [elTicko, setElTicko] = useState(false);

  async function fetchData() {
    if (Cookies.get("user") !== "") {
      console.log('if userActive true in fetchData():', Cookies.get("userActive"));
      const resultPriorities = await axios.get(
        "http://localhost:8080/priority?" + "user=" + Cookies.get("user")
      );
      setPriorities(resultPriorities.data);
      const resultDepartments = await axios.get(
        "http://localhost:8080/departments?" + "user=" + Cookies.get("user")
      );
      setDepartments(resultDepartments.data);
      const resultMatriculas = await axios.get(
        "http://localhost:8080/matriculas?" + "user=" + Cookies.get("user")
      );
      setMatriculas(resultMatriculas.data);
    } else {
      history.push("/");
    }
  };

  async function setExpands() {
    if (Cookies.get("user") !== "") {
      const resultPriorities = await axios.get(
        "http://localhost:8080/priority?" + "user=" + Cookies.get("user")
      );
      resultPriorities.data.map((course, coursesIndex) => {
        courseExpands[coursesIndex] = false;
      });
    } else {
      history.push("/");
    }
  };

  useEffect(() => {
    setExpands();
  }, []);

  useEffect(() => {
    fetchData();
  }, [elTicko]);

  const handleCourseExpand = (courseIndex) => {
    courseExpands[courseIndex] = !courseExpands[courseIndex];
    setCourseExpands(courseExpands);
    forceUpdate();
    console.log(courseExpands);
  }

  const forceUpdate = () => {
    setElTicko(!elTicko);
  };

  const previousMatricula = () => {
    setDisablePrevious(matriculaIndex - 1 <= 0 ? true : false);
    setDisableNext(false);
    setMatriculaIndex(matriculaIndex - 1);
  };

  const nextMatricula = () => {
    setDisableNext(matriculaIndex + 1 >= matriculas.length - 1 ? true : false);
    setDisablePrevious(false);
    setMatriculaIndex(matriculaIndex + 1);
  };

  const transferCourse = async (
    sourceListIndex,
    targetListIndex,
    valueIndex,
    priorityCourseIndex,
    departmentIndex,
    matriculaIndex
  ) => {
    await axios.post(
      "http://localhost:8080/transferCourse?" +
      "sourceListIndex=" +
      sourceListIndex +
      "&targetListIndex=" +
      targetListIndex +
      "&valueIndex=" +
      valueIndex +
      "&priorityCourseIndex=" +
      priorityCourseIndex +
      "&departmentIndex=" +
      departmentIndex +
      "&matriculaIndex=" +
      matriculaIndex +
      "&user=" +
      Cookies.get("user")
    );
  };

  const transferSection = async (
    sourceListIndex,
    targetListIndex,
    valueIndex,
    priorityCourseIndex,
    matriculaIndex
  ) => {
    await axios.post(
      "http://localhost:8080/transferSection?" +
      "sourceListIndex=" +
      sourceListIndex +
      "&targetListIndex=" +
      targetListIndex +
      "&valueIndex=" +
      valueIndex +
      "&priorityCourseIndex=" +
      priorityCourseIndex +
      "&matriculaYear=" +
      matriculas[matriculaIndex].period.matyear +
      "&matriculaPeriod=" +
      matriculas[matriculaIndex].period.semester +
      "&user=" +
      Cookies.get("user")
    );
  };

  const logout = async () => {
    Cookies.set("user", "");
    history.push("/");
    await axios.post('http://localhost:8080/logout?user=' + Cookies.get("user"))
  };

  const listCourseSwitch = (listIndex, departmentIndex) => {
    switch (listIndex) {
      case 0:
        return priorities;
      case 1:
        return departments[departmentIndex].courses;
      default:
        console.log("INVALID");
    }
  };

  const listSectionSwitch = (listIndex, priorityCourseIndex) => {
    switch (listIndex) {
      case 0:
        return priorities[priorityCourseIndex].sections;
      case 2:
        return matriculas[matriculaIndex].sections;
      default:
        console.log("INVALID");
    }
  };

  const listNameSwitch = (listType, listIndex) => {
    if (listIndex === 0) {
      return "from: priority courses";
    } else {
      if (listType === 0) {
        return "from: department courses";
      } else {
        return "from: matricula sections";
      }
    }
  };

  const onDragOver = (e) => {
    e.preventDefault();
  };

  const onDragStart = (e, listType, valueIndex, sourceListIndex, mainListIndex) => {
    setIsCourseSection(listType);
    setValueIndex(valueIndex);
    setSourceListIndex(sourceListIndex);
    setPriorityCourseIndex(mainListIndex);
    setDepartmentIndex(mainListIndex);
  };

  const onDrop = (e, targetListIndex) => {
    let valueIndex = tempValueIndex;
    let sourceListIndex = tempSourceListIndex;

    if (targetListIndex !== sourceListIndex) {

      switch (isCourseSection) {
        case 0:
          if (targetListIndex !== 2) {
            transferCourse(
              sourceListIndex,
              targetListIndex,
              valueIndex,
              priorityCourseIndex,
              departmentIndex,
              matriculaIndex,
              Cookies.get("user")
            );
          }
          break;
        case 1:
          if (targetListIndex !== 1) {
            transferSection(
              sourceListIndex,
              targetListIndex,
              valueIndex,
              priorityCourseIndex,
              matriculaIndex,
              Cookies.get("user")
            );
          }
          break;
        default:
          console.log("INVALID");
      }

      forceUpdate();
    }
  };

  const renderDepartments = (departmentsList, title, listIndex) => {
    return (
      <div>
        <List>
          <Typography className={classes.drawerTypography}>{title}</Typography>
          {departmentsList.map((department, departmentsIndex) => (
            <div key={departmentsIndex}>
              <ListItem>
                <Typography style={{ fontWeight: '800' }}>{department.name}</Typography>
              </ListItem>
              <List>
                {department.courses.map((course, coursesIndex) => (
                  <ListItem
                    style={{ cursor: 'pointer' }}
                    key={coursesIndex}
                    onClick={(e) => {
                      onDragStart(e, 0, coursesIndex, 1, departmentsIndex);
                      onDrop(e, 0);
                    }}
                  >
                    <CourseCard
                      courseCode={course.courseCode}
                      courseName={course.name}
                      credits={course.credits}
                      color={course.color}
                    />
                  </ListItem>
                ))}
              </List>
            </div>
          ))}
        </List>
      </div>
    );
  };

  const renderPriorityCourses = (coursesList, title, listIndex) => {
    return (
      <div
        onDragOver={(e) => {
          onDragOver(e);
        }}
        onDrop={(e) => onDrop(e, listIndex)}
      >
        <Grid
          container
          style={{
            display: "flex",
            alignContent: "center",
            justifyContent: "center",
            paddingTop: '1rem',
          }}
        >
          <Grid item>
            <Typography className={classes.drawerTypography}>
              {title}
            </Typography>
          </Grid>
          <Grid item>
            <DeleteForeverIcon style={{ height: "2rem", width: "2rem" }} />
          </Grid>
        </Grid>

        <List style={{ alignItems: "center" }}>
          {coursesList.map((course, coursesIndex) => (
            <div key={coursesIndex}>
              <ListItem
                style={{ cursor: "pointer" }}
                draggable={true}
                key={coursesIndex}
                onDragStart={(e) =>
                  onDragStart(e, 0, coursesIndex, 0, coursesIndex)
                }
                onClick={() => handleCourseExpand(coursesIndex)}
              >
                <CourseCard
                  courseCode={course.courseCode}
                  courseName={course.name}
                  credits={course.credits}
                  color={course.color}
                />
              </ListItem>
              <Collapse
                in={courseExpands[coursesIndex]}
                timeout="auto"
                unmountOnExit
              >
                <List>
                  {course.sections.map((section, sectionsIndex) => (
                    <ListItem
                      style={{ cursor: "pointer" }}
                      draggable={true}
                      key={sectionsIndex}
                      onDragStart={(e) =>
                        onDragStart(e, 1, sectionsIndex, 0, coursesIndex)
                      }
                    >
                      <SectionCard
                        courseCode={section.courseCode}
                        section={section.secNum}
                        courseName={section.courseName}
                        professor={section.professor}
                        credits={section.credits}
                        color={section.color}
                        time={section.time}
                        population={section.population}
                        capacity={section.capacity}
                        day={section.day}
                        period={section.period}
                        availability={course.availability}
                        description={course.description}
                      />
                    </ListItem>
                  ))}
                </List>
              </Collapse>
            </div>
          ))}
        </List>
      </div>
    );
  };

  const renderMatricula = (matriculaList, title, listIndex) => {
    return (
      <div
        onDragOver={(e) => {
          onDragOver(e);
        }}
        onDrop={(e) => onDrop(e, listIndex)}
      >
        <Grid container style={{ display: 'flex', alignContent: 'center', justifyContent: 'center' }}>
          <Grid item>
            <Typography className={classes.drawerTypography}>
              {title}
            </Typography>
          </Grid>
          <Grid item>
            <DeleteForeverIcon
              style={{ height: "2rem", width: "2rem" }}
            />
          </Grid>
        </Grid>
        <div style={{ overflowY: "scroll", height: "550px", width: "250px" }}>
          <List style={{ alignItems: "center" }}>
            {matriculaList.map((sections, sectionsIndex) => (
              <ListItem
                style={{ cursor: "pointer" }}
                draggable={matriculaIndex === 0}
                key={sectionsIndex}
                onDragStart={(e) =>
                  onDragStart(e, 1, sectionsIndex, 2, matriculaIndex)
                }
              >
                <SectionCard
                  courseCode={sections.courseCode}
                  section={sections.secNum}
                  courseName={sections.courseName}
                  professor={sections.professor}
                  credits={sections.credits}
                  color={sections.color}
                  time={sections.time}
                  population={sections.population}
                  capacity={sections.capacity}
                  day={sections.day}
                  period={sections.period}
                  availability={matriculas[matriculaIndex].courses[sectionsIndex].availability}
                  description={matriculas[matriculaIndex].courses[sectionsIndex].description}
                />
              </ListItem>
            ))}
          </List>
        </div>
      </div>
    );
  };

  return (
    <div className={classes.root}>
      <AppBar position="fixed" className={classes.appBar}>
        <Toolbar>
          <img src={MacademiaTitle} className={classes.image} />
          <Button
            className={classes.logoutButton}
            style={{ outline: 0 }}
            onClick={() => logout()}
          >
            <Typography>Logout</Typography>
          </Button>
        </Toolbar>
      </AppBar>

      <Drawer
        className={classes.drawer}
        variant="permanent"
        classes={{ paper: classes.drawerPaper }}
      >
        <Toolbar />
        <div className={classes.drawerContainer}>
          {priorities !== null ? (
            renderPriorityCourses(priorities, "Priority Courses", 0)

          ) : (
              <div />
            )}
          <Divider />
          {departments !== null ? (
            renderDepartments(departments, "Departments", 1)
          ) : (
              <div />
            )}
          <Divider />
        </div>
      </Drawer>

      <main className={classes.content} style={{ height: "100vh" }}>
        <Toolbar />
        <div className={classes.centerContent}>
          <div
            style={{ display: "flex", alignItems: "center", padding: "50px" }}
          >
            <IconButton disabled={disableNext} onClick={() => nextMatricula()}>
              <NavigateBeforeIcon style={{ height: "50px", width: "50px" }} />
            </IconButton>
          </div>

          <Card elevation={3} style={{ width: "70%" }}>
            {matriculas !== null ? (
              <CardContent>
                <Grid item style={{ textAlign: "center" }}>
                  <Typography style={{ fontSize: "30px" }}>
                    {matriculas[matriculaIndex].period.semesterAsString}{" "}
                    {matriculas[matriculaIndex].period.matyear}
                  </Typography>
                </Grid>

                <Divider />

                <Grid container justify="space-around" alignItems="center">
                  <Grid item>
                    {renderMatricula(
                      matriculas[matriculaIndex].sections,
                      "My Matricula",
                      2
                    )}
                  </Grid>

                  <Grid item>
                    <Grid
                      container
                      direction="column"
                      justify="center"
                      alignItems="center"
                      spacing={3}
                    >
                      <Grid item>
                        <ScheduleCard
                          currentMatricula={matriculas[matriculaIndex]}
                        />
                      </Grid>

                      <Grid item>
                        <Typography style={{ color: "#7f7f7f" }}>
                          Total Credits:{" "}
                          {matriculas[matriculaIndex].totalCredits}
                        </Typography>
                      </Grid>
                    </Grid>
                  </Grid>
                </Grid>
              </CardContent>
            ) : (
                <div />
              )}
          </Card>

          <div
            style={{ display: "flex", alignItems: "center", padding: "50px" }}
          >
            <IconButton
              disabled={disablePrevious}
              onClick={() => previousMatricula()}
            >
              <NavigateNextIcon style={{ height: "50px", width: "50px" }} />
            </IconButton>
          </div>
        </div>
      </main>
    </div>
  );
}
