import React, { Component } from "react";
import "./App.css";
import Dashboard from "./Component/Dashboard";
import Header from "./Component/Layout/Header";
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddProject from "./Component/Project/addProject.js";

class App extends Component {
  render() {
    return (
      <Router>
        <div className="App">
          <Header />
          <Route exact path="/Dashboard" component={Dashboard} />
          <Route exact path="/addProject" component={AddProject} />
        </div>
      </Router>
    );
  }
}

export default App;
