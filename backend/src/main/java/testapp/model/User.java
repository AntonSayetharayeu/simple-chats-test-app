package testapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import testapp.model.enums.UserGender;
import testapp.model.enums.UserRole;

import java.time.LocalDateTime;

@Entity
@Table(name = "\"app_user\"")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String username;

    @Email
    private String email;

    private String password;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private UserGender gender;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("%s Email: %s", username, email);
    }
}
