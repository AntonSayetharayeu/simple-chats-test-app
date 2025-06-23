package testapp.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginDTO {
    @NotBlank
    @Email
    private String userEmail;
    @NotBlank
    private String userPassword;
}
