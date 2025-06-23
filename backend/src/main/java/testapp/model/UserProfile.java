package testapp.model;

import jakarta.persistence.*;
import testapp.model.enums.UserGender;

@Entity
@Table(name = "app_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;

    private String imagePath;

    private String imageAltName;

    @Enumerated(EnumType.STRING)
    private UserGender gender;
}
