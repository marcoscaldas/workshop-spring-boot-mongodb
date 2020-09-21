package com.marcoscaldas.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcoscaldas.workshopmongo.domain.User;
import com.marcoscaldas.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired   // para instanciar o repository
	private UserRepository repo;
	
	public List<User> findall(){
		return repo.findAll();
	}

}
