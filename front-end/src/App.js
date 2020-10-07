import React from 'react';
import Header from './Header/header';
import Courses from './Courses/courses';
import './App.css';
import Drawer from "./Header/drawer.js";


function App() {
  return (
    <div className="App">
      <Header />
      <Drawer/>
      {/* <Courses /> */}
    </div>
  );
}

export default App;
