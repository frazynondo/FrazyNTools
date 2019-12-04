import React, { Component } from "react";
import ProjectItems from "./Project/ProjectItems";
import "bootstrap/dist/css/bootstrap.min.css";
import CreateProjectButton from "./Project/CreateProjectButton";

class Dashboard extends Component {
  render() {
    return (
      <div className="projects">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">PROJECTS</h1>
              <br />
              <CreateProjectButton />
              <br />
              <hr />
              <ProjectItems />
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Dashboard;
