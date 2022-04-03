package com.hermes.msg.service;

import com.hermes.msg.dto.MessageDTO;
import com.hermes.msg.exceptions.HermesAppExeption;
import com.hermes.msg.exceptions.UsersNotFoundException;
import com.hermes.msg.model.Message;
import com.hermes.msg.model.Users;
import com.hermes.msg.repository.MessageRepository;
import com.hermes.msg.repository.UsersRepository;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;


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

    @Override
    public void deleteMessage(long userID, long messageID) {
        Users users = usersRepository
                .findById(userID).orElseThrow(()-> new UsersNotFoundException("Users","id",userID));

        Message message = messageRepository.findById(messageID)
                .orElseThrow(()-> new UsersNotFoundException("Message","id",messageID));

        if(!message.getId().equals(users.getId())){
            throw new HermesAppExeption(HttpStatus.BAD_REQUEST,"Message does not belong to user");
        }

        messageRepository.delete(message);
    }

    // This method converts Entity to DTO
    private MessageDTO mapDTO(Message message){
        MessageDTO messageDTO = modelMapper.map(message,MessageDTO.class);
        return messageDTO;
    }

    // This method converts DTO to Entity
    private Message mapEntity(MessageDTO messageDTO){
        Message message = modelMapper.map(messageDTO, Message.class);
        return message;
    }
}
