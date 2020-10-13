import React from "react";
import clsx from "clsx";
import { makeStyles, useTheme } from "@material-ui/core/styles";
import Drawer from "@material-ui/core/Drawer";
import CssBaseline from "@material-ui/core/CssBaseline";
import Toolbar from "@material-ui/core/Toolbar";
import List from "@material-ui/core/List";
import Typography from "@material-ui/core/Typography";
import Divider from "@material-ui/core/Divider";
import IconButton from "@material-ui/core/IconButton";
import MenuIcon from "@material-ui/icons/Menu";
import ChevronLeftIcon from "@material-ui/icons/ChevronLeft";
import ChevronRightIcon from "@material-ui/icons/ChevronRight";
import ListItem from "@material-ui/core/ListItem";
import ListItemText from "@material-ui/core/ListItemText";
import './drawer.css';

export default function PersistentDrawerLeft() {

  const theme = useTheme();
  const [open, setOpen] = React.useState(false);

  const handleDrawerOpen = () => {
    setOpen(true);
  };

  const handleDrawerClose = () => {
    setOpen(false);
  };

  return (
    <div id="root">
      {/* <CssBaseline /> */}
      <Toolbar>
        <IconButton
          color="inherit"
          aria-label="open drawer"
          onClick={handleDrawerOpen}
          edge="start"
          id="menuButton hide"
        >
          <MenuIcon />
        </IconButton>
      </Toolbar>
      <Drawer
        className="drawer"
        variant="persistent"
        anchor="left"
        open={open}
        id={{
          paper: "drawPaper",
        }}
      >
        <div className="drawHeader">
          <IconButton onClick={handleDrawerClose}>
            {theme.direction === "ltr" ? (
              <ChevronLeftIcon/>
            ) : (
              <ChevronRightIcon />
            )}
          </IconButton>
        </div>
        <Divider />
        <List>
          <Typography id="TypographyDrawer">My Courses</Typography>
          {["Curso 1", "Curso 2", "Curso 3", "Curso 4"].map((text, index) => (
            <ListItem button key={text} id="ListItemButton">
              <ListItemText primary={text} id="ListItemText" />
            </ListItem>
          ))}
        </List>
        <Divider />
        <List>
          <Typography id="TypographyDrawer">Department of INSO</Typography>
          {["Course 1", "Course 2", "Course 3"].map((text, index) => (
            <ListItem button key={text} id="ListItemButton">
              <ListItemText primary={text} id="ListItemText" />
            </ListItem>
          ))}
        </List>
      </Drawer>
      <main
        id="content contentShift"
      ></main>
    </div>
  );
}
