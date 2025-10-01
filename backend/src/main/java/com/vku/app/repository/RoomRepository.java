package com.vku.app.repository;

import com.vku.app.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, String> {
    List<Room> findByIsActiveTrue();
}
