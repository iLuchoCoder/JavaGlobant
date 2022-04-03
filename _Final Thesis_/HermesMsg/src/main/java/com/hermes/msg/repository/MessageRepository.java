package com.hermes.msg.repository;

import com.hermes.msg.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {

    public List<Message> findByUsersId(long id);
}
