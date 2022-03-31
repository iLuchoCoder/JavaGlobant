package com.hermes.msg.service;

import com.hermes.msg.dto.UserDTO;

import java.util.List;

public interface UserService {

    public UserDTO createUser(UserDTO userDTO);

    public List<UserDTO> listAllUsers();

    public UserDTO getUserById(long id);

    public UserDTO updateUser(UserDTO userDTO, long id);

    public void deleteUser(long id);
}
