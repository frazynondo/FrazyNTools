package com.FrazyNondo.fntool.repositories;

import com.FrazyNondo.fntool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ProjectRepository extends CrudRepository<Project, Long> {


    Project findByprojectIdentifier(String projectID);

//    @Override
//    Iterable<Project> findAllById(Iterable<Long> iterable);
}
