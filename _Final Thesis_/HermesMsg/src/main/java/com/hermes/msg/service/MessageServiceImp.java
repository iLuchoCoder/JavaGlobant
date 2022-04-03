package com.hermes.msg.service;

import com.hermes.msg.dto.MessageDTO;
import com.hermes.msg.exceptions.HermesAppExeption;
import com.hermes.msg.exceptions.UsersNotFoundException;
import com.hermes.msg.model.Message;
import com.hermes.msg.model.Users;
import com.hermes.msg.repository.MessageRepository;
import com.hermes.msg.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<MessageDTO> getMessagesByUserId(long id) {
        List<Message> messages = messageRepository.findByUsersId(id);
        return messages.stream().map(message -> mapDTO(message)).collect(Collectors.toList());
    }

    @Override
    public MessageDTO getMessageByID(long userID, long messageID) {
        Users users = usersRepository
                .findById(userID).orElseThrow(()-> new UsersNotFoundException("Users","id",userID));

        Message message = messageRepository.findById(messageID)
                .orElseThrow(()-> new UsersNotFoundException("Message","id",messageID));

        if(!message.getId().equals(users.getId())){
            throw new HermesAppExeption(HttpStatus.BAD_REQUEST,"Message does not belong to user");
        }

        return mapDTO(message);
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
