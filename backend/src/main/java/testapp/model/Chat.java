package testapp.model;

import jakarta.persistence.*;
import testapp.model.enums.ChatType;

import java.time.LocalDateTime;

@Entity
@Table(name = "app_chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ChatType chatType;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
