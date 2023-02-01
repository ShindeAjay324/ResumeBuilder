package com.resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resume.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String username);

}
