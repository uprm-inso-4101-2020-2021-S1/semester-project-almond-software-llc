import React from 'react';
import Header from './Header/header';
import Matricula from './Matricula/matricula';
import TempHeader from './Header/temp-header';
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
