package testapp.model;

import java.time.LocalDateTime;

public class Message {

    private Long id;

    private String content;

    private LocalDateTime timestamp;

    private Chat chat;

    private User sender;
}
