package com.hermes.msg.service;

import com.hermes.msg.dto.UsersDTO;
import com.hermes.msg.dto.UsersResponse;

public interface UsersService {

    public UsersDTO createUser(UsersDTO usersDTO);

    public UsersResponse listAllUsers(int pageNum, int pageSize);

    public UsersDTO getUserById(long id);

    public UsersDTO updateUser(UsersDTO usersDTO, long id);

    public void deleteUser(long id);
}
