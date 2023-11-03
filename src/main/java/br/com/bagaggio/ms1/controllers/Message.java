package br.com.bagaggio.ms1.controllers;

public class Message {
    private String helloMessage;
    private String worldMessage;

    public Message(String helloMessage, String worldMessage) {
        this.helloMessage = helloMessage;
        this.worldMessage = worldMessage;
    }

    public Message() {}
    public String getHelloMessage() {
        return helloMessage;
    }

    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }

    public String getWorldMessage() {
        return worldMessage;
    }

    public void setWorldMessage(String worldMessage) {
        this.worldMessage = worldMessage;
    }
}
