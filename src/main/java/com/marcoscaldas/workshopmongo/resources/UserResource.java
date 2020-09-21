package com.marcoscaldas.workshopmongo.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcoscaldas.workshopmongo.domain.User;
import com.marcoscaldas.workshopmongo.dto.UserDTO;
import com.marcoscaldas.workshopmongo.services.UserService;

@RestController   // para falar que a classe vai ser um rest controller
@RequestMapping(value ="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	// ou @GetMapoing
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findall();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value ="/{id}", method=RequestMethod.GET)
	// ou @GetMapoing
	public ResponseEntity<UserDTO> findById(@PathVariable String id){ // pathvariable para aceitar o id com id do parametro
		Optional<User> obj = service.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO());
	}
	

}
