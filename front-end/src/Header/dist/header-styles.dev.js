
import { makeStyles } from "@material-ui/core/styles";
import styled from "styled-components";

function _defineProperty(obj, key, value) {
  if (key in obj) {
    Object.defineProperty(obj, key, {
      value: value, enumerable: true, configurable: true, writable: true
    });
  }
  else {
    obj[key] = value;
  }
  return obj;
}

var useStyles = StyleSheet.create(makeStyles((theme) =>{
  return {
    grow: {
      flexGrow: 1
    },
    menuButton: {
      marginRight: theme.spacing(2)
    },
    title: _defineProperty({
      display: 'none'
    }, theme.breakpoints.up('sm'), {
      display: 'block'
    }),
    sectionDesktop: _defineProperty({
      display: 'none'
    }, theme.breakpoints.up('md'), {
      display: 'flex'
    }),
    sectionMobile: _defineProperty({
      display: 'flex'
    }, theme.breakpoints.up('md'), {
      display: 'none'
    })
  };
}));

export default useStyles;