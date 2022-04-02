package com.hermes.msg.service;

import com.hermes.msg.dto.MessageDTO;

public interface MessageService {

    public MessageDTO createMessage(long id, MessageDTO messageDTO);
}
