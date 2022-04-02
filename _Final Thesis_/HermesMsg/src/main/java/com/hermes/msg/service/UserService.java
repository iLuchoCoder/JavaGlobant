package com.hermes.msg.service;

import com.hermes.msg.dto.UserDTO;
import com.hermes.msg.dto.UserResponse;

public interface UserService {

    public UserDTO createUser(UserDTO userDTO);

    public UserResponse listAllUsers(int pageNum, int pageSize);

    public UserDTO getUserById(long id);

    public UserDTO updateUser(UserDTO userDTO, long id);

    public void deleteUser(long id);
}
