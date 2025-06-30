package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.WhatsAppMessage;
import com.example.demo.service.WhatsAppBotService;

@RestController
@RequestMapping("/whatsapp")
public class WhatsAppController {

    @Autowired
    private WhatsAppBotService botService;

    @PostMapping("/receive")
    public ResponseEntity<String> receiveMsg(@RequestBody WhatsAppMessage whatsAppMessage) {
        String reply = botService.proMsg(whatsAppMessage.getFrom(), whatsAppMessage.getBody());
        return ResponseEntity.ok(reply);
    }
}
