package com.tamarith.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tamarith.api.model.entity.User;
import com.tamarith.api.model.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	//Mapeo del GET, status del response a 200 - OK
	@GetMapping("/user/{userId}")
	@ResponseStatus(HttpStatus.OK)
	public User getUser(@PathVariable int userId) {

		User user = userService.getUser(userId);
		return user;
	}
	
	//Mapeo del POST, status del response a 201 - CREATED
	@PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED)
	public User addEmployee(@RequestBody User user) {

		//La idea es que no llegue ningún valor al id (JSON puede pasarlo a 0)
		//Se fuerza a null para asegurar que crea uno nuevo

		user.setId(null);
		userService.saveUser(user);
		return user;
	}
}