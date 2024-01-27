package outcast.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * @author outcast c-cute hột me 😳
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty
    private String status;
    @JsonProperty
    private String message;
}
