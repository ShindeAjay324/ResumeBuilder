package com.resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resume.entity.ProjectDetails;
@Repository
public interface ProjectDetailsRespository extends JpaRepository<ProjectDetails, Integer> {

}
