package com.secure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secure.entity.User;

public interface UserRepository  extends JpaRepository<User, Integer> {

 User findByUserName(String username);

}
