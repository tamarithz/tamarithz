package com.tamarith.api.model.service;

import java.util.List;

import com.tamarith.api.model.entity.Usuario;

public interface UserService {

		public List<Usuario> getUsers();

		public void saveUser(Usuario theUser);

		public Usuario getUser(Integer theId);

		public void deleteUser(Integer theId);
}
