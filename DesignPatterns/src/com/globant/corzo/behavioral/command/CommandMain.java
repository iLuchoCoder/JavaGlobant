package com.globant.corzo.behavioral.command;

import java.io.IOException;

class CommandMain {

    public static void main(String args[]) throws IOException {

        SimpleRemoteControl remote =
                new SimpleRemoteControl();
        Light light = new Light();
        Stereo stereo = new Stereo();

        remote.setCommand(new
                LightOnCommand(light));
        remote.buttonWasPressed();
        remote.setCommand(new
                StereoOnWithCDCommand(stereo));
        remote.buttonWasPressed();
        remote.setCommand(new
                StereoOffCommand(stereo));
        remote.buttonWasPressed();
    }
}
