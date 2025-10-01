    package com.vku.app.websocket;

    import com.vku.app.entity.Message;
    import com.vku.app.entity.User;
    import com.vku.app.repository.RoomRepository;
    import com.vku.app.repository.UserRepository;
    import com.vku.app.service.MessageService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.messaging.handler.annotation.DestinationVariable;
    import org.springframework.messaging.handler.annotation.MessageMapping;
    import org.springframework.messaging.handler.annotation.SendTo;
    import org.springframework.stereotype.Controller;

    @Controller
    public class MessageHandler {
        @Autowired
        private MessageService messageService;

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private RoomRepository roomRepository;

        @MessageMapping("/chat/{roomId}" ) // client gửi tới /app/chat/{roomId}
        @SendTo("/topic/room/{roomId}") // server gửi tới /topic/room/{roomId}
        public Message handleMessage(@DestinationVariable String roomId, Message message){
            if (roomRepository.findById(roomId).isEmpty()) {
                throw new RuntimeException("Room not found");
            }
            if (userRepository.findById(message.getUserId()).isEmpty()) {
                throw new RuntimeException("User not found");
            }

            message.setRoomId(roomId);
            Message savedMessage = messageService.saveMessage(message);
            System.out.println("Saved message: " + savedMessage);
            User user = userRepository.findById(message.getUserId()).orElseThrow();
            savedMessage.setUsername(user.getUsername());

            return savedMessage;
        }


    }
