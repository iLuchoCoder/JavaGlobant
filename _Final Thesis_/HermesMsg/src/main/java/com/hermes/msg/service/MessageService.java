package com.hermes.msg.service;

import com.hermes.msg.dto.MessageDTO;

import java.util.List;

public interface MessageService {

    public MessageDTO createMessage(long id, MessageDTO messageDTO);

    public List<MessageDTO> getMessagesByUserId(long id);

    public MessageDTO getMessageByID(long userID, long messageID);

    public void deleteMessage(long userID, long messageID);

}
