package testapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@Entity
public class ChatUser {

    private Long chatId;

    private Long userId;

    private LocalDateTime enteredAt;

    private LocalDateTime leftAt;

    @PrePersist
    public void prePersist() {
        enteredAt = LocalDateTime.now();
        leftAt = null;
    }
}
