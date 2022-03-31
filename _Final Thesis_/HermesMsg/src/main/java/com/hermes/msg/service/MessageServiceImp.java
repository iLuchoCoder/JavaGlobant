package com.hermes.msg.service;

import com.hermes.msg.dto.MessageDTO;
import com.hermes.msg.model.Message;
import com.hermes.msg.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImp implements MessageService{

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public MessageDTO createMessage(MessageDTO messageDTO) {
        // Converting a DTO to an Entity
        Message message = new Message();
        message.setOrigin(messageDTO.getOrigin());
        message.setDestination(messageDTO.getDestination());
        message.setCc(messageDTO.getCc());
        message.setBcc(messageDTO.getBcc());
        message.setSubject(messageDTO.getSubject());
        message.setBody(messageDTO.getBody());
        message.setAttachment(messageDTO.getAttachment());

        Message newMessage = messageRepository.save(message);

        //Convert from entity to DTO
        MessageDTO messageResponse = new MessageDTO();
        messageResponse.setId(newMessage.getId());
        messageResponse.setOrigin(newMessage.getOrigin());
        messageResponse.setDestination(newMessage.getDestination());
        messageResponse.setCc(newMessage.getCc());
        messageResponse.setBcc(newMessage.getBcc());
        messageResponse.setSubject(newMessage.getSubject());
        messageResponse.setBody(newMessage.getBody());
        messageResponse.setAttachment(newMessage.getAttachment());

        return messageResponse;
    }
}
