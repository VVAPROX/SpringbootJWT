package outcast.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import outcast.token.Token;

import java.util.List;
import java.util.Optional;

/**
 * @author outcast c-cute hột me 😳
 */
public interface TokenRepository extends JpaRepository<Token, Integer> {
    @Query("""
        SELECT t FROM Token t
        INNER JOIN User u ON t.user.id = u.id
        WHERE u.id = :id AND (t.expired = false OR t.revoked = false)
        """)
    List<Token> findAllValidTokenByUser(int id);

    Optional<Token> findByToken(String token);
}
