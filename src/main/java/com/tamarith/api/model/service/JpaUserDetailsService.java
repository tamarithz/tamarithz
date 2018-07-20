package com.tamarith.api.model.service;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tamarith.api.model.dao.UserDAO;
import com.tamarith.api.model.entity.Role;
import com.tamarith.api.model.entity.Usuario;

//TODO : implementar la interfaz UserService en esta clase

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService , UserService{ 
	
	@Autowired
	private UserDAO userDAO;
	
	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        Usuario usuario = userDAO.findByEmail(username);
        
        if(usuario == null) {
        	logger.error("No existe el usuario asociado a '" + username);
        	throw new UsernameNotFoundException("No ha sido posible encontrar " + username + " en la base de datos");
        }
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        for(Role role: usuario.getRoles()) {
        	logger.info("Role: ".concat(role.getAuthority()));
        	authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        
        if(authorities.isEmpty()) {
        	logger.error("El usuario con email : " + username + "  - no tiene un rol asignado");
        	throw new UsernameNotFoundException("No hay rol ningún rol asignado para " + username);
        }
        
		return new User(usuario.getEmail(), usuario.getPassword(), usuario.isEnabled(), true, true, true, authorities);
	}

	@Override
	public void saveUser(Usuario theUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario getUser(Integer theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer theId) {
		// TODO Auto-generated method stub
		
	}
}
