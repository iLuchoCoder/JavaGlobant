package com.globant.corzo.behavioral.observer;

import java.io.IOException;

class ObserverMain {

    public static void main(String args[]) throws IOException {
        MessageSubscriberOne s1 = new MessageSubscriberOne();
        MessageSubscriberTwo s2 = new MessageSubscriberTwo();

        MessagePublisher p = new MessagePublisher();

        p.attach(s1);
        p.attach(s2);

        p.notifyUpdate(new Message("First Message"));

        p.detach(s2);

        p.notifyUpdate(new Message("Second Message"));

    }
}

