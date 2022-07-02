package com.secure.service;

import java.util.ArrayList;

import com.secure.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.secure.Repository.UserRepository;



@Service
public class customUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user=	repository.findByUserName(username);
	
		return new org.springframework.security.core.userdetails.User(user.getUserName(),
				user.getUserPassword(),new ArrayList<>());
}

}
