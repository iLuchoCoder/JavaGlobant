package com.hermes.msg.controller;

import com.hermes.msg.dto.MessageDTO;
import com.hermes.msg.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hermes/")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/users/{id}/messages")
    public List<MessageDTO> listMessagesByUserId(@PathVariable(value = "id") long id){
        return messageService.getMessagesByUserId(id);
    }

    @GetMapping("/users/{userID}/messages/{messageID}")
    public ResponseEntity<MessageDTO> getMessageById(@PathVariable(value = "userID") long userID, @PathVariable(value = "messageID") long messageID){
        MessageDTO messageDTO = messageService.getMessageByID(userID, messageID);
        return new ResponseEntity<>(messageDTO,HttpStatus.OK);
    }

    @PostMapping("/users/{id}/messages")
    public ResponseEntity<MessageDTO> sendMessage(@PathVariable(value = "id") long id, @RequestBody MessageDTO messageDTO){
        if(!messageDTO.getCc().isEmpty())
        {
            new ResponseEntity<>(messageService.createMessage(Long.parseLong(messageDTO.getCc()),messageDTO), HttpStatus.CREATED);
        }
        if(!messageDTO.getBcc().isEmpty())
        {
            new ResponseEntity<>(messageService.createMessage(Long.parseLong(messageDTO.getBcc()),messageDTO), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(messageService.createMessage(Long.parseLong(messageDTO.getDestination()),messageDTO), HttpStatus.CREATED);
    }
}
