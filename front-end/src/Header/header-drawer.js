import React from "react";
import Drawer from "@material-ui/core/Drawer";
import AppBar from "@material-ui/core/AppBar";
import CssBaseline from "@material-ui/core/CssBaseline";
import Toolbar from "@material-ui/core/Toolbar";
import List from "@material-ui/core/List";
import Divider from "@material-ui/core/Divider";
import ListItem from "@material-ui/core/ListItem";
import ListItemText from "@material-ui/core/ListItemText";
import CourseCard from "../CourseCard/coursecard.js";
import IconButton from "@material-ui/core/IconButton";
import AccountCircle from "@material-ui/icons/AccountCircle";
import Macademia from "./macademia.png";
import { makeStyles } from "@material-ui/core/styles";
import MenuItem from "@material-ui/core/MenuItem";
import Menu from "@material-ui/core/Menu";
import Matricula from '../Matricula/matricula.js';
import Avatar from "@material-ui/core/Avatar";
import Accordion from "@material-ui/core/Accordion";
import AccordionSummary from "@material-ui/core/AccordionSummary";
import AccordionDetails from "@material-ui/core/AccordionDetails";
import Typography from "@material-ui/core/Typography";
import ExpandMoreIcon from "@material-ui/icons/ExpandMore";
import { withStyles } from "@material-ui/core/styles";
import MuiAccordion from "@material-ui/core/Accordion";
import MuiAccordionSummary from "@material-ui/core/AccordionSummary";
import MuiAccordionDetails from "@material-ui/core/AccordionDetails";

const drawerWidth = 270;

const useStyles = makeStyles((theme) => ({
  grow: {
    flexGrow: 1,
  },
  image: {
    width: 60,
    height: 60,
  },
  sectionDesktop: {
    display: "none",
    [theme.breakpoints.up("xs")]: {
      display: "flex",
    },
  },
  sectionMobile: {
    display: "flex",
    [theme.breakpoints.up("md")]: {
      display: "none",
    },
  },
  root: {
    display: "flex",
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
    textShadow: "1px 1px 2px green",
    fontFamily: "Epilogue",
    fontFamily: "'Roboto', sans-serif",
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
    backgroundColor: theme.palette.background.default,
    padding: theme.spacing(3),
  },
  large: {
    width: theme.spacing(7),
    height: theme.spacing(7),
  },
  profilePicture: {
    display: "flex",
    marginLeft: "1rem",
    marginTop: "1rem",
  },
  welcomeName: {
    display: "block",
    fontFamily: "'Roboto', sans-serif",
  },
  planB: {
    display: "flex",
    position: "absolute",
    top: "5.5rem",
    left: "1rem",
    fontFamily: "'Roboto', sans-serif",
  },
  root: {
    width: "100%",
  },
  heading: {
    fontSize: theme.typography.pxToRem(15),
    fontWeight: theme.typography.fontWeightRegular,
  },
  drawerCards: {
    boxShadow: "10px 10px 10px #f2f2f2",
  },
}));



export default function PrimarySearchAppBar() {
  
  const classes = useStyles();
  const [anchorEl, setAnchorEl] = React.useState(null);
  const [mobileMoreAnchorEl, setMobileMoreAnchorEl] = React.useState(null);

  const isMenuOpen = Boolean(anchorEl);
  const isMobileMenuOpen = Boolean(mobileMoreAnchorEl);

  const handleProfileMenuOpen = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleMobileMenuClose = () => {
    setMobileMoreAnchorEl(null);
  };

  const handleMenuClose = () => {
    setAnchorEl(null);
    handleMobileMenuClose();
  };

  const cards = [
    <CourseCard />,
    <CourseCard />,
    <CourseCard />,
    <CourseCard />,
    <CourseCard />,
  ];
  const names = ["Francis"];

  const menuId = "primary-search-account-menu";
  const renderMenu = (
    <Menu
      anchorEl={anchorEl}
      anchorOrigin={{ vertical: "top", horizontal: "right" }}
      id={menuId}
      keepMounted
      transformOrigin={{ vertical: "top", horizontal: "right" }}
      open={isMenuOpen}
      onClose={handleMenuClose}
    >
      <MenuItem onClick={handleMenuClose}>Profile</MenuItem>
      <MenuItem onClick={handleMenuClose}>My account</MenuItem>
    </Menu>
  );

  const mobileMenuId = "primary-search-account-menu-mobile";
  const renderMobileMenu = (
    <Menu
      anchorEl={mobileMoreAnchorEl}
      anchorOrigin={{ vertical: "top", horizontal: "right" }}
      id={mobileMenuId}
      keepMounted
      transformOrigin={{ vertical: "top", horizontal: "right" }}
      open={isMobileMenuOpen}
      onClose={handleMobileMenuClose}
    >
      <MenuItem onClick={handleProfileMenuOpen}>
        <IconButton
          aria-label="account of current user"
          aria-controls="primary-search-account-menu"
          aria-haspopup="true"
          color="inherit"
        >
          <AccountCircle />
        </IconButton>
        <p>Profile</p>
      </MenuItem>
    </Menu>
  );

  const Accordion = withStyles({
    root: {
      border: "1px solid rgba(0, 0, 0, .125)",
      boxShadow: "none",
      "&:not(:last-child)": {
        borderBottom: 0,
      },
      "&:before": {
        display: "none",
      },
      "&$expanded": {
        margin: "auto",
      },
    },
    expanded: {},
  })(MuiAccordion);

  const AccordionSummary = withStyles({
    root: {
      backgroundColor: "rgba(0, 0, 0, .03)",
      borderBottom: "1px solid rgba(0, 0, 0, .125)",
      marginBottom: -1,
      minHeight: 56,
      "&$expanded": {
        minHeight: 56,
      },
    },
    content: {
      "&$expanded": {
        margin: "12px 0",
      },
    },
    expanded: {},
  })(MuiAccordionSummary);

  const AccordionDetails = withStyles((theme) => ({
    root: {
      padding: theme.spacing(2),
    },
  }))(MuiAccordionDetails);

  const [expanded, setExpanded] = React.useState("panel1");

  const handleChange = (panel) => (event, newExpanded) => {
    setExpanded(newExpanded ? panel : false);
  };

  return (
    <div className={classes.root}>
      <AppBar position="fixed" className={classes.appBar}>
        <CssBaseline />
        <Toolbar>
          <img src={Macademia} className={classes.image} />

          <div className={classes.grow} />
          <div className={classes.sectionDesktop}>
            <IconButton
              edge="end"
              aria-label="account of current user"
              aria-controls={menuId}
              aria-haspopup="true"
              onClick={handleProfileMenuOpen}
              color="inherit"
            >
              <AccountCircle />
            </IconButton>
          </div>
        </Toolbar>
      </AppBar>

      <Drawer
        className={classes.drawer}
        variant="permanent"
        classes={{
          paper: classes.drawerPaper,
        }}
        anchor="left"
      >
        <div className={classes.profilePicture}>
          <Avatar
            alt="Remy Sharp"
            src="/static/images/avatar/1.jpg"
            className={classes.large}
          />
          <div className={classes.welcomeName}>
            <Typography>Welcome,</Typography>
            {names.map((name, index) => (
              <Typography>{name}</Typography>
            ))}
          </div>
        </div>

        <div className={classes.planB}>
          <Typography>Plan B Feature</Typography>
        </div>

        <div className={classes.toolbar} />

        <Accordion
          square
          expanded={expanded === "panel1"}
          onChange={handleChange("panel1")}
          style={{ width: "auto" }}
        >
          <AccordionSummary aria-controls="panel1d-content" id="panel1d-header">
            <Typography>Mandatory</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <List>
              {cards.map((text, index) => (
                <ListItem button key={text}>
                  <ListItemText
                    primary={text}
                    className={classes.drawerCards}
                  />
                </ListItem>
              ))}
            </List>
          </AccordionDetails>
        </Accordion>

        <Accordion
          square
          expanded={expanded === "panel2"}
          onChange={handleChange("panel2")}
          style={{ width: "auto" }}
        >
          <AccordionSummary aria-controls="panel2d-content" id="panel2d-header">
            <Typography>Socio Humanistics</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <List>
              {cards.map((text, index) => (
                <ListItem button key={text}>
                  <ListItemText
                    primary={text}
                    className={classes.drawerCards}
                  />
                </ListItem>
              ))}
            </List>
          </AccordionDetails>
        </Accordion>

        <Accordion
          square
          expanded={expanded === "panel3"}
          onChange={handleChange("panel3")}
          style={{ width: "auto" }}
        >
          <AccordionSummary aria-controls="panel3d-content" id="panel3d-header">
            <Typography>Recommended</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <List>
              {cards.map((text, index) => (
                <ListItem button key={text}>
                  <ListItemText
                    primary={text}
                    className={classes.drawerCards}
                  />
                </ListItem>
              ))}
            </List>
          </AccordionDetails>
        </Accordion>

        <Accordion
          square
          expanded={expanded === "panel4"}
          onChange={handleChange("panel4")}
          style={{ width: "auto" }}
        >
          <AccordionSummary aria-controls="panel4d-content" id="panel4d-header">
            <Typography>Free</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <List>
              {cards.map((text, index) => (
                <ListItem button key={text}>
                  <ListItemText
                    primary={text}
                    className={classes.drawerCards}
                  />
                </ListItem>
              ))}
            </List>
          </AccordionDetails>
        </Accordion>
      </Drawer>
      {renderMobileMenu}
      {renderMenu}

      <main className={classes.content}>
        <div className={classes.toolbar} />

        <div className={classes.centerContent}>
          <List className={classes.cardLists}>
            {cards.map((card, index) => (
              <Matricula card={card}></Matricula>
            ))}
          </List>
        </div>
      </main>
    </div>
  );
}
