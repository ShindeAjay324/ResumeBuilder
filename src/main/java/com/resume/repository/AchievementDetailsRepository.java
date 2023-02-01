package com.resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resume.entity.AchievementDetails;
@Repository
public interface AchievementDetailsRepository extends JpaRepository<AchievementDetails, Integer> {

}
