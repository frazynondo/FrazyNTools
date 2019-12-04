package com.FrazyNondo.fntool.web;

import com.FrazyNondo.fntool.domain.Project;
import com.FrazyNondo.fntool.services.MapValidationError;
import com.FrazyNondo.fntool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationError mapValidationError;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){

   ResponseEntity<?> errorMap = mapValidationError.MapValidationService(result);
   if(errorMap!=null) return errorMap;

        Project project1 = projectService.saveOrUpdate(project);
        return  new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }
    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId){
        Project project = projectService.findProjectByIdentifier(projectId);
        return  new ResponseEntity<Project>(project, HttpStatus.OK);
    }
    @GetMapping("/all")
    public Iterable<Project> getAllProjects(){
        return projectService.findAllProjects();
    }
    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable String projectId){
        projectService.deleteProjectByIdentifier(projectId);

        return new ResponseEntity<String>("Project with Id: '"+projectId+"' was deleted", HttpStatus.OK);
    }

}


