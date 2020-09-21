package com.marcoscaldas.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcoscaldas.workshopmongo.domain.User;
import com.marcoscaldas.workshopmongo.services.UserService;

@RestController   // para falar que a classe vai ser um rest controller
@RequestMapping(value ="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	// ou @GetMapoing
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findall();
		return ResponseEntity.ok().body(list);
	}

}
