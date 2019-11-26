package com.FrazyNondo.fntool.services;

import com.FrazyNondo.fntool.domain.Project;
import com.FrazyNondo.fntool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project){

        return projectRepository.save(project);
    }
}
