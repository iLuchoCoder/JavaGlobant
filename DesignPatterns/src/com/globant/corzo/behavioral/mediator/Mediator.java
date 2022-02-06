package com.globant.corzo.behavioral.mediator;

import com.globant.corzo.creationals.builder.Task;
import com.globant.corzo.creationals.builder.TaskBuilder;

import java.io.IOException;
import java.util.Date;

class Mediator {

    public static void main(String args[]) throws IOException {

        {
            IChatRoom chatroom = new ChatRoom();

            User user1 = new ChatUser(chatroom,"1", "Alex");
            User user2 = new ChatUser(chatroom,"2", "Juan");
            User user3 = new ChatUser(chatroom,"3", "Carlos");
            User user4 = new ChatUser(chatroom,"4", "David");

            chatroom.addUser(user1);
            chatroom.addUser(user2);
            chatroom.addUser(user3);
            chatroom.addUser(user4);

            user1.send("Hello Juan", "2");
            user2.send("Hi David", "1");
            user3.send("David, are you there? ", "4");
        }
    }
}

