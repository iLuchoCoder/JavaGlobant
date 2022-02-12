package com.globant.corzo.creationals.builder;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

class Builder {

    public static void main(String args[]) throws IOException {

//        Task task = new Task (5,test, hello,false, hello,false, hello,false, hello,false, hello,false, hello,false, hello,false, hello,false, hello,false, hello,false);
        Task task = new TaskBuilder(5)
                .setDescription("Hello")
                .build();
        System.out.println(task);
    }
}
