package com.hermes.msg.service;

import com.hermes.msg.dto.MessageDTO;
import com.hermes.msg.exceptions.UsersNotFoundException;
import com.hermes.msg.model.Message;
import com.hermes.msg.model.Users;
import com.hermes.msg.repository.MessageRepository;
import com.hermes.msg.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImp implements MessageService{

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public MessageDTO createMessage(long id, MessageDTO messageDTO) {
        Message message = mapEntity(messageDTO);
        Users users = usersRepository
                .findById(id).orElseThrow(()-> new UsersNotFoundException("Users","id",id));
        message.setUsers(users);
        Message newMessage = messageRepository.save(message);
        return mapDTO(newMessage);
    }

    // This method converts Entity to DTO
    private MessageDTO mapDTO(Message message){
        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setId(message.getId());
        messageDTO.setOrigin(message.getOrigin());
        messageDTO.setDestination(message.getDestination());
        messageDTO.setCc(message.getCc());
        messageDTO.setBcc(message.getBcc());
        messageDTO.setSubject(message.getSubject());
        messageDTO.setBody(message.getBody());
        messageDTO.setAttachment(message.getAttachment());

        return messageDTO;
    }

    // This method converts DTO to Entity
    private Message mapEntity(MessageDTO messageDTO){
        Message message = new Message();

        message.setId(messageDTO.getId());
        message.setOrigin(messageDTO.getOrigin());
        message.setDestination(messageDTO.getDestination());
        message.setCc(messageDTO.getCc());
        message.setBcc(messageDTO.getBcc());
        message.setSubject(messageDTO.getSubject());
        message.setBody(messageDTO.getBody());
        message.setAttachment(messageDTO.getAttachment());

        return message;
    }
}
