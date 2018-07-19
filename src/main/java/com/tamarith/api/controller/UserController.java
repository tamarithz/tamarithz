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

import com.tamarith.api.model.entity.Usuario;
import com.tamarith.api.model.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> getUsers() {
		return userService.getUsers();
	}
	
	//Mapeo del GET, status del response a 200 - OK
	@GetMapping("/user/{userId}")
	@ResponseStatus(HttpStatus.OK)
	public Usuario getUser(@PathVariable int userId) {

		Usuario user = userService.getUser(userId);
		return user;
	}
	
	//Mapeo del POST, status del response a 201 - CREATED
	@PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario addEmployee(@RequestBody Usuario user) {

		//La idea es que no llegue ningún valor al id (JSON puede pasarlo a 0)
		//Se fuerza a null para asegurar que crea uno nuevo

		user.setIdusuario(null);
		userService.saveUser(user);
		return user;
	}
}