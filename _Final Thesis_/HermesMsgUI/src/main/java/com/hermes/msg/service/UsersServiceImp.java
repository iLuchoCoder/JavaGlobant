package com.hermes.msg.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.hermes.msg.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hermes.msg.controller.dto.UsersRegisterDTO;
import com.hermes.msg.model.Role;
import com.hermes.msg.repository.UsersRepository;

@Service
public class UsersServiceImp implements UsersService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Users save(UsersRegisterDTO registerDTO) {
		Users users = new Users(registerDTO.getUsername(), registerDTO.getName(), registerDTO.getLast_name(),
				registerDTO.getIdentification_number(),registerDTO.getAddress(), registerDTO.getCity(),
				registerDTO.getState(), registerDTO.getCountry(), registerDTO.getZip_code(),
				passwordEncoder.encode(registerDTO.getPassword()),Arrays.asList(new Role("ROLE_USER")));
		return usersRepository.save(users);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = usersRepository.findByUsername(username);
		if(users == null) {
			throw new UsernameNotFoundException("Invalid user or password");
		}
		return new User(users.getUsername(), users.getPassword(), mapAuthRoles(users.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapAuthRoles(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
	@Override
	public List<Users> listUsers() {
		return usersRepository.findAll();
	}
}
