package com.FrazyNondo.fntool.web;

import com.FrazyNondo.fntool.domain.Project;
import com.FrazyNondo.fntool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Binding;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
        if(result.hasErrors()){
            return  new ResponseEntity<String>("Invalid Project Object", HttpStatus.BAD_REQUEST);
        }

        Project project1 = projectService.saveOrUpdate(project);
        return  new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }
}
