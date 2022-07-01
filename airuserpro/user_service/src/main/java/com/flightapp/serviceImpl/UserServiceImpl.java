package com.flightapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entity.User;
import com.flightapp.repository.UserRepository;
import com.flightapp.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public Integer saveUser(User user) {
	  	User saveUser =userRepo.save(user);
	  	
	  	return saveUser.getId();
	  	
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public Optional<User> getUser(Integer id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}

	@Override
	public void deleteUser(Integer id) {
		userRepo.deleteById(id);
		
	}

}
