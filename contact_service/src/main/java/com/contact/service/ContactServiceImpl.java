package com.contact.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.contact.entity.Contact;

@Service
public class ContactServiceImpl  implements ContactService {
	
	List<Contact> list=List.of(
			new Contact(1L,"amar@gmail.com","amar",1311L),
			new Contact(1L,"RAVI@gmail.com","RAVI",1312L)

			);

	public List<Contact> getContactsoFUser(Long userId) {
		// TODO Auto-generated method stub
		
		
		return list.stream().filter(cont -> cont.getUserId().equals(userId)).collect(Collectors.toList());
	
	}
	
	

}
