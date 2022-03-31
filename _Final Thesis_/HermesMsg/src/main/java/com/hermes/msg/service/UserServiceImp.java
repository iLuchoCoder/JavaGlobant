package com.hermes.msg.service;

import com.hermes.msg.dto.UserDTO;
import com.hermes.msg.model.User;
import com.hermes.msg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        // Converting a DTO to an Entity
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setName(userDTO.getName());
        user.setLast_name(userDTO.getLast_name());
        user.setId_number(userDTO.getId_number());
        user.setAddress(userDTO.getAddress());
        user.setCity(userDTO.getCity());
        user.setState(userDTO.getState());
        user.setCountry(userDTO.getCountry());
        user.setZip_code(userDTO.getZip_code());
        user.setRoles(userDTO.getRoles());
        user.setAllMessages(userDTO.getAllMessages());

        User newUser = userRepository.save(user);

        //Convert from entity to DTO
        UserDTO userResponse = new UserDTO();
        userResponse.setId(newUser.getId());
        userResponse.setUsername(newUser.getUsername());
        userResponse.setName(newUser.getName());
        userResponse.setLast_name(newUser.getLast_name());
        userResponse.setId_number(newUser.getId_number());
        userResponse.setAddress(newUser.getAddress());
        userResponse.setCity(newUser.getCity());
        userResponse.setState(newUser.getState());
        userResponse.setCountry(newUser.getCountry());
        userResponse.setZip_code(newUser.getZip_code());
        userResponse.setRoles(newUser.getRoles());
        userResponse.setAllMessages(newUser.getAllMessages());

        return userResponse;
    }
}
