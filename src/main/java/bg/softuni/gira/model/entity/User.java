package bg.softuni.gira.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import static bg.softuni.gira.constraint.Global.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "username", nullable = false, unique = true)
    @Length(min = 3, max = 20, message = USERNAME_LENGTH_MSG)
    private String username;
    @Column(name = "password", nullable = false)
    @Length(min = 3, message = PASSWORD_LENGTH_MSG)
    private String password;
    @Column(name = "email", nullable = false, unique = true)
    @Email(message = EMAIL_VALID_MSG)
    private String email;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
