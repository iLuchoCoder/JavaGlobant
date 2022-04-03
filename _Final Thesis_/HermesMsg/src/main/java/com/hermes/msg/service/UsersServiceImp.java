package com.hermes.msg.service;

import com.hermes.msg.dto.UsersDTO;
import com.hermes.msg.dto.UsersResponse;
import com.hermes.msg.exceptions.UsersNotFoundException;
import com.hermes.msg.model.Users;
import com.hermes.msg.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImp implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsersDTO createUser(UsersDTO usersDTO) {
        Users users = mapEntity(usersDTO);
        Users new_users = usersRepository.save(users);
        UsersDTO userResponse = mapDTO(new_users);
        return userResponse;

    }

    // This method converts Entity to DTO
    private UsersDTO mapDTO(Users users){
        UsersDTO usersDTO = modelMapper.map(users,UsersDTO.class);
        return usersDTO;
    }

    // This method converts DTO to Entity
    private Users mapEntity(UsersDTO usersDTO){
        Users users = modelMapper.map(usersDTO,Users.class);
        return users;
    }

    @Override
    public UsersResponse listAllUsers(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        Page<Users> users = usersRepository.findAll(pageable);
        List<Users> usersList = users.getContent();
        List<UsersDTO> content = usersList.stream().map(user -> mapDTO(user)).collect(Collectors.toList());
        UsersResponse usersResponse = new UsersResponse();
        usersResponse.setContent(content);
        usersResponse.setNumPage(users.getNumber());
        usersResponse.setSizePage(users.getSize());
        usersResponse.setTotalElements(users.getTotalElements());
        usersResponse.setTotalPages(users.getTotalPages());
        usersResponse.setLast(users.isLast());
        return usersResponse;
    }

    @Override
    public UsersDTO getUserById(long id) {
        Users users = usersRepository
                .findById(id).orElseThrow(()-> new UsersNotFoundException("Users","id",id));
        return mapDTO(users);
    }

    @Override
    public UsersDTO updateUser(UsersDTO usersDTO, long id) {
        Users users = usersRepository
                .findById(id).orElseThrow(()-> new UsersNotFoundException("Users","id",id));

        users.setUsername(usersDTO.getUsername());
        users.setName(usersDTO.getName());
        users.setLast_name(usersDTO.getLast_name());
        users.setId_number(usersDTO.getId_number());
        users.setAddress(usersDTO.getAddress());
        users.setCity(usersDTO.getCity());
        users.setState(usersDTO.getState());
        users.setCountry(usersDTO.getCountry());
        users.setZip_code(usersDTO.getZip_code());

        Users usersUpdated = usersRepository.save(users);

        return mapDTO(usersUpdated);
    }

    @Override
    public void deleteUser(long id) {
        Users users = usersRepository
                .findById(id).orElseThrow(()-> new UsersNotFoundException("Users","id",id));

        usersRepository.delete(users);

    }
}
