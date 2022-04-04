package com.hermes.msg.controller;

import com.hermes.msg.dto.LoginDTO;
import com.hermes.msg.dto.RegisterDTO;
import com.hermes.msg.model.Role;
import com.hermes.msg.model.Users;
import com.hermes.msg.repository.RoleRepository;
import com.hermes.msg.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/hermes/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseEntity<>("You have successfully logged in", HttpStatus.OK);

    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterDTO registerDTO){
        if(usersRepository.existsByUsername(registerDTO.getUsername())){
            return new ResponseEntity<>("Existing user",HttpStatus.BAD_REQUEST);
        }

        Users users = new Users();

        users.setUsername(registerDTO.getUsername());
        users.setName(registerDTO.getName());
        users.setLast_name(registerDTO.getLast_name());
        users.setId_number(registerDTO.getId_number());
        users.setAddress(registerDTO.getAddress());
        users.setCity(registerDTO.getCity());
        users.setState(registerDTO.getState());
        users.setCountry(registerDTO.getCountry());
        users.setZip_code(registerDTO.getZip_code());
        users.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
        users.setRoles(Collections.singleton(roles));

        usersRepository.save(users);

        return new ResponseEntity<>("Registered user successfully, you can log in.....",HttpStatus.OK);
    }
}
