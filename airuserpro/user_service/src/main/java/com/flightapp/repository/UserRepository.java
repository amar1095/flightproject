package com.flightapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public Optional<User> findById(Integer id);

}
