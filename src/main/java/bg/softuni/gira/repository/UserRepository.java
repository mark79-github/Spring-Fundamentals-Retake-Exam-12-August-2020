package bg.softuni.gira.repository;

import bg.softuni.gira.model.entity.User;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import java.util.Optional;

import static bg.softuni.gira.constraint.Global.EMAIL_VALID_MSG;
import static bg.softuni.gira.constraint.Global.USERNAME_LENGTH_MSG;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(@Length(min = 3, max = 20, message = USERNAME_LENGTH_MSG) String username);

    Optional<User> findByEmail(@Email(message = EMAIL_VALID_MSG) String email);
}
