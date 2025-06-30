package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class WhatsAppBotService {

    public String proMsg(String from, String body) {
        String reply = switch (body.toLowerCase()) {
            case "hii", "hi", "hello", "hey" -> "Hello! How can I help you?";
            case "help" -> "You can ask me about info.";
            
            default -> "Sorry, I didn't understand that. Type 'help' for options.";
        };

        sendReply(from, reply);
        return reply;
    }

    private void sendReply(String to, String message) {
        System.out.println("Sending message to: " + to);
        System.out.println("Message: " + message);
    }
}
