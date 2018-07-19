package com.tamarith.api.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tamarith.api.model.dao.UserDAO;
import com.tamarith.api.model.entity.Usuario;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	/**
	 * Método para obtener todos los usuarios
	 */
	@Override
	@Transactional(readOnly=true)
	public List<Usuario> getUsers() {
		return (List<Usuario>) userDAO.findAll();
	}
	/**
	 * Método para guardar un empleado
	 */
	@Override
	@Transactional
	public void saveUser(Usuario theUser) {
		userDAO.save(theUser);	
	}
	/**
	 * Método para obtener un usuario por su id
	 */
	@Override
	@Transactional(readOnly=true)
	public Usuario getUser(Integer theId) {
		return userDAO.findById(theId).get();
	}

	/**
	 * Método para eliminar un usuario
	 * 
	 * TODO aviso antes de realizar esta acción: en vista (HTML)
	 */
	@Override
	@Transactional
	public void deleteUser(Integer theId) {
		userDAO.deleteById(theId);		
	}
}
