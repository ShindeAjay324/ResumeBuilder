package com.resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resume.entity.EducationDetails;
@Repository
public interface EducationDetailsRepository extends JpaRepository<EducationDetails, Integer> {

}
