package com.example.securityJpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securityJpa.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUserName(String userName);
}
