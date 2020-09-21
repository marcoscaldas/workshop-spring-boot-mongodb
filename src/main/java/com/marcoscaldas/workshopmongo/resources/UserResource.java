package com.marcoscaldas.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<UserDTO> findById(@PathVariable String id){ 
		Optional<User> obj = service.findById(id);		
		return ResponseEntity.ok().body(new UserDTO());
	}
	
	@RequestMapping( method=RequestMethod.POST)  // ou colocar postmappin
	
	public ResponseEntity<Void> insert (@RequestBody UserDTO objDto) { 
		
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build(); 
		
	}
	
	@RequestMapping(value ="/{id}", method=RequestMethod.DELETE)	
	public ResponseEntity<Void> delete(@PathVariable String id){ 
		service.delete(id);		
		return ResponseEntity.noContent().build();
	}
	
	
}
