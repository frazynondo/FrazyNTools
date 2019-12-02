package com.FrazyNondo.fntool.services;

import com.FrazyNondo.fntool.Exceptions.ProjectIdException;
import com.FrazyNondo.fntool.domain.Project;
import com.FrazyNondo.fntool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
