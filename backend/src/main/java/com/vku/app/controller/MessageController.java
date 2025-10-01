package com.vku.app.controller;

import com.vku.app.entity.Message;
import com.vku.app.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/{roomId}")
    public List<Message> getMessages(@PathVariable String roomId) {
        return messageService.getMessagesByRoomId(roomId);
    }

}
