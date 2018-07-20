package com.tamarith.api.model.service;


import com.tamarith.api.model.entity.Usuario;

public interface UserService {

	//TODO implementar la gestion de todos los usuarios del sistema
		//public List<Usuario> getUsers();

		public void saveUser(Usuario theUser);

		public Usuario getUser(Integer theId);

		public void deleteUser(Integer theId);
}
