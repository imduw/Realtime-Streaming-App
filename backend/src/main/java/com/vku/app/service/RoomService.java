package com.vku.app.service;

import com.vku.app.entity.Room;
import com.vku.app.repository.RoomRepository;
import com.vku.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    public Room createRoom(Room room){
        if (userRepository.findById(room.getOwnerId()).isEmpty()) {
            throw new RuntimeException("Owner not found");
        }
        return roomRepository.save(room);
    }

    public List<Room> getActiveRooms(){
        return roomRepository.findByIsActiveTrue();
    }
}
