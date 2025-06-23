package testapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import testapp.model.enums.ChatType;

import java.time.LocalDateTime;

@Entity
@Table(name = "app_chat")
public class Chat {

    private Long id;

    private String name;

    private ChatType chatType;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
