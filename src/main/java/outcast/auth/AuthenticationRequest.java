package outcast.auth;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import outcast.annotations.NoSpecialCharacters;

/**
 * @author outcast c-cute hột me 😳
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    @NotEmpty(message = "Username cannot be empty!")
    @NoSpecialCharacters
    private String username;

    @NotEmpty(message = "Password cannot be empty!")
    private String password;
}
