package com.hermes.msg.service;

import com.hermes.msg.dto.UserDTO;
import com.hermes.msg.dto.UserResponse;
import com.hermes.msg.exceptions.UserNotFoundException;
import com.hermes.msg.model.User;
import com.hermes.msg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = mapEntity(userDTO);
        User new_user = userRepository.save(user);
        UserDTO userResponse = mapDTO(new_user);
        return userResponse;

    }

    // This method converts Entity to DTO
    private UserDTO mapDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setName(user.getName());
        userDTO.setLast_name(user.getLast_name());
        userDTO.setId_number(user.getId_number());
        userDTO.setAddress(user.getAddress());
        userDTO.setCity(user.getCity());
        userDTO.setState(user.getState());
        userDTO.setCountry(user.getCountry());
        userDTO.setZip_code(user.getZip_code());
        userDTO.setRoles(user.getRoles());
        userDTO.setAllMessages(user.getAllMessages());

        return userDTO;
    }

    // This method converts DTO to Entity
    private User mapEntity(UserDTO userDTO){
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

        return user;
    }

    @Override
    public UserResponse listAllUsers(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        Page<User> users = userRepository.findAll(pageable);
        List<User> userList = users.getContent();
        List<UserDTO> content = userList.stream().map(user -> mapDTO(user)).collect(Collectors.toList());
        UserResponse userResponse = new UserResponse();
        userResponse.setContent(content);
        userResponse.setNumPage(users.getNumber());
        userResponse.setSizePage(users.getSize());
        userResponse.setTotalElements(users.getTotalElements());
        userResponse.setTotalPages(users.getTotalPages());
        userResponse.setLast(users.isLast());
        return userResponse;
    }

    @Override
    public UserDTO getUserById(long id) {
        User user = userRepository
                .findById(id).orElseThrow(()-> new UserNotFoundException("User","id",id));
        return mapDTO(user);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, long id) {
        User user = userRepository
                .findById(id).orElseThrow(()-> new UserNotFoundException("User","id",id));

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

        User userUpdated = userRepository.save(user);

        return mapDTO(userUpdated);
    }

    @Override
    public void deleteUser(long id) {
        User user = userRepository
                .findById(id).orElseThrow(()-> new UserNotFoundException("User","id",id));

        userRepository.delete(user);

    }
}
