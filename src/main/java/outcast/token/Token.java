package outcast.token;

import jakarta.persistence.*;
import lombok.*;
import outcast.user.User;


/**
 * @author outcast c-cute hột me 😳
 */
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Token {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(unique = true)
    public String token;

    @Enumerated(EnumType.STRING)
    public TokenType tokenType = TokenType.BEARER;
    @Setter
    @Getter
    public boolean revoked;
    @Setter
    @Getter
    public boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;
}