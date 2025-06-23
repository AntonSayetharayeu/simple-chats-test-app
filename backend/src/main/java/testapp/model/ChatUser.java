package testapp.model;

import jakarta.persistence.*;
import testapp.model.enums.ChatRole;

import java.time.LocalDateTime;

@Entity
@Table(name = "app_chat_user")
public class ChatUser {
    @EmbeddedId
    private ChatUserId id;

    @ManyToOne
    @MapsId("chatId")
    private Chat chat;

    @ManyToOne
    @MapsId("userId")
    private User user;

    private LocalDateTime enteredAt;

    private LocalDateTime leftAt;

    @Enumerated(EnumType.STRING)
    private ChatRole userRole;

    @PrePersist
    public void prePersist() {
        enteredAt = LocalDateTime.now();
        leftAt = null;
    }
}
