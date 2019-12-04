package com.FrazyNondo.fntool.services;

import com.FrazyNondo.fntool.Exceptions.ProjectIdException;
import com.FrazyNondo.fntool.domain.Project;
import com.FrazyNondo.fntool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project){
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e){
            throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exist");
        }

    }

    public Project findProjectByIdentifier(String projectID){

        Project project = projectRepository.findByprojectIdentifier(projectID.toUpperCase());
        if (project == null){
            throw new ProjectIdException("Project ID '"+projectID+"' already exist");
        }
        return project;
    }

    public  Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByprojectIdentifier(projectId);
        if(project == null){
            throw new ProjectIdException("Cannot find Project with ID '"+projectId+"'. Does not exist");
        }
        projectRepository.delete(project);
    }
}
