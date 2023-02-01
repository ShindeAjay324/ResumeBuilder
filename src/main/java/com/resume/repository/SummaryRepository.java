package com.resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resume.entity.Summary;
@Repository
public interface SummaryRepository extends JpaRepository<Summary, Integer> {

}
