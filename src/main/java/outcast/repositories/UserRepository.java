package outcast.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import outcast.user.User;

import java.util.Optional;

/**
 * @author outcast c-cute hột me 😳
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String userName);
}
