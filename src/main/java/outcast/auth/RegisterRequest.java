package outcast.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import outcast.annotations.NoSpecialCharacters;
import outcast.annotations.ValidPassword;

/**
 * @author outcast c-cute hột me 😳
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RegisterRequest {

    @NotEmpty(message = "First name cannot be empty!")
    private String firstname;

    @NotEmpty(message = "Last name cannot be empty!")
    private String lastname;

    @NoSpecialCharacters
    @Size(min = 6, message = "User name must be at least 6 characters long!")
    private String username;

    @NotEmpty(message = "Email cannot be empty!")
    @Email(message = "Invalid email!")
    private String email;

    @ValidPassword
    @Size(min = 8, message = "Password must be at least 8 characters long!")
    private String password;

}
