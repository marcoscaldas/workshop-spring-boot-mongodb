package com.marcoscaldas.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcoscaldas.workshopmongo.domain.Post;
import com.marcoscaldas.workshopmongo.domain.User;
import com.marcoscaldas.workshopmongo.dto.UserDTO;
import com.marcoscaldas.workshopmongo.repository.PostRepository;
import com.marcoscaldas.workshopmongo.repository.UserRepository;
import com.marcoscaldas.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired   // para instanciar o repository
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
}
