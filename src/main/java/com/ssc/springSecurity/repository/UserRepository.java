package com.ssc.springSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssc.springSecurity.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
}
