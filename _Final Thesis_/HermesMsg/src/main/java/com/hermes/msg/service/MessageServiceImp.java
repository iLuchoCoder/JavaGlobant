package com.hermes.msg.service;

import com.hermes.msg.dto.MessageDTO;
import com.hermes.msg.exceptions.UserNotFoundException;
import com.hermes.msg.model.Message;
import com.hermes.msg.model.User;
import com.hermes.msg.repository.MessageRepository;
import com.hermes.msg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImp implements MessageService{

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public MessageDTO createMessage(long id, MessageDTO messageDTO) {
        Message message = mapEntity(messageDTO);
        User user = userRepository
                .findById(id).orElseThrow(()-> new UserNotFoundException("User","id",id));
        message.setUser(user);
        Message newMessage = messageRepository.save(message);
        return mapDTO(newMessage);
    }

    // This method converts Entity to DTO
    private MessageDTO mapDTO(Message message){
        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setId(message.getId());
        messageDTO.setFrom(message.getFrom());
        messageDTO.setTo(message.getTo());
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
        message.setFrom(messageDTO.getFrom());
        message.setTo(messageDTO.getTo());
        message.setCc(messageDTO.getCc());
        message.setBcc(messageDTO.getBcc());
        message.setSubject(messageDTO.getSubject());
        message.setBody(messageDTO.getBody());
        message.setAttachment(messageDTO.getAttachment());

        return message;
    }
}
