package com.resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resume.entity.Profile;
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer>{

}
