package com.hermes.msg.service;

import java.util.List;

import com.hermes.msg.model.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.hermes.msg.controller.dto.UsersRegisterDTO;


public interface UsersService extends UserDetailsService{

	public Users save(UsersRegisterDTO registerDTO);
	
	public List<Users> listUsers();
	
}
