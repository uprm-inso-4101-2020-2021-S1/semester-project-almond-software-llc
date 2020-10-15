import React from 'react';
import Header from './Header/header';
import Matricula from './Matricula/matricula';
import CourseList from './CourseList/courselist'
import TempHeader from './Header/temp-header';
import { fade, makeStyles } from '@material-ui/core/styles';
import './App.css';
import Drawer from "./Header/drawer.js";


const drawerWidth = 240;

const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
  },
  drawer: {
    [theme.breakpoints.up('sm')]: {
      width: drawerWidth,
      flexShrink: 0,
    },
  },
  // necessary for content to be below app bar
  toolbar: theme.mixins.toolbar,
  drawerPaper: {
    width: drawerWidth,
  },
  content: {
    flexGrow: 1,
    padding: theme.spacing(3),
  },
}));

function App() {

  const classes = useStyles();

  return (
    <div className={classes.root}>

      <Header />
      {/* <Drawer/> */}

      {/* <nav className={classes.drawer} aria-label="mailbox folders">
        <CourseList />
      </nav> */}

      <main className={classes.content}>
        <div className={classes.toolbar} />
        <Matricula />
      </main>

    </div>
  );
}

export default App;
