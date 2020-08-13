package bg.softuni.gira.model.bind;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static bg.softuni.gira.constraint.Global.*;

public class UserLoginBindingModel {

    @Email(message = EMAIL_VALID_MSG)
    @NotBlank(message = EMAIL_VALID_MSG)
    private String email;
    @Length(min = 3, message = PASSWORD_LENGTH_MSG)
    private String password;

    public UserLoginBindingModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
