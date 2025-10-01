package com.vku.app.service;

import com.vku.app.entity.Message;
import com.vku.app.repository.MessageRepository;
import com.vku.app.repository.RoomRepository;
import com.vku.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    public Message saveMessage(Message message) {
        if(roomRepository.findById(message.getRoomId()).isEmpty()) throw new RuntimeException("Room is not active");

        if(userRepository.findById(message.getUserId()).isEmpty()) throw new RuntimeException("User is not exist");
        return messageRepository.save(message);
    }

    public List<Message> getMessagesByRoomId(String roomId) {
        return messageRepository.findByRoomIdOrderByTimestampAsc(roomId);
    }


}
