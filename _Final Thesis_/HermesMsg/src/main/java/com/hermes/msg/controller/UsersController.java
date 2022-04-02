package com.hermes.msg.controller;

import com.hermes.msg.dto.UsersDTO;
import com.hermes.msg.dto.UsersResponse;
import com.hermes.msg.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hermes/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public UsersResponse getUsers(@RequestParam(value = "pagNum", defaultValue = "0", required = false) int pagNum,
                                  @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        return usersService.listAllUsers(pagNum,pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDTO> getUserById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(usersService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UsersDTO> createUser(@RequestBody UsersDTO usersDTO) {
        return new ResponseEntity<>(usersService.createUser(usersDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersDTO> updateUser(@RequestBody UsersDTO usersDTO, @PathVariable(name = "id") long id) {
        UsersDTO userResponse = usersService.updateUser(usersDTO, id);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") long id) {
        usersService.deleteUser(id);
        return new ResponseEntity<>("Users deleted successfully", HttpStatus.OK);
    }
}
