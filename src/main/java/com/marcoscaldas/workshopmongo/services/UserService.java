package com.marcoscaldas.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcoscaldas.workshopmongo.domain.User;
import com.marcoscaldas.workshopmongo.dto.UserDTO;
import com.marcoscaldas.workshopmongo.repository.UserRepository;
import com.marcoscaldas.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired   // para instanciar o repository
	private UserRepository repo;
	
	public List<User> findall(){
		return repo.findAll();
	}
	
	public Optional<User> findById(String id) {
	//	User user = repo.findOne(id);
		Optional<User> user = repo.findById(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto nao encontrado");
		}
		return user;
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete (String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
