package com.hermes.msg.controller;

import com.hermes.msg.dto.MessageDTO;
import com.hermes.msg.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hermes/")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/user/{id}/messages")
    public ResponseEntity<MessageDTO> sendMessage(@PathVariable(value = "id") long id, @RequestBody MessageDTO messageDTO){
        return new ResponseEntity<>(messageService.createMessage(id,messageDTO), HttpStatus.CREATED);
    }



}
