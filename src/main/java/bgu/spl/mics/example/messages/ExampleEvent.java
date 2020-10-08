package bgu.spl.mics.example.messages;

import bgu.spl.mics.Event;
import bgu.spl.mics.Message;

public class ExampleEvent implements Event<String>{

    private String senderName;

    public ExampleEvent(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderName() {
        return senderName;
    }

    @Override
    public Message getMessage() {
        return null;
    }
}