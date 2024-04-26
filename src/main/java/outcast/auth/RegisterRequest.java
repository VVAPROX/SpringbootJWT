package outcast.auth;

import lombok.*;

/**
 * @author outcast c-cute hột me 😳
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
}
