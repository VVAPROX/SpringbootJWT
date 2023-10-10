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
    @Query(value = """
            select t from Token t inner join User u\s
            on t.user.id = u.id\s
            where u.id = :id and (t.expired = false or t.revoked = false)\s
            """)
    List<Token> findAllValidTokenByUser(int id);

    Optional<Token> findByToken(String token);
}
