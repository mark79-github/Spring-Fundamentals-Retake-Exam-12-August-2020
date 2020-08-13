package bg.softuni.gira.model.bind;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import static bg.softuni.gira.constraint.Global.*;

public class UserRegisterBindingModel {

    @Length(min = 3, max = 20, message = USERNAME_LENGTH_MSG)
    private String username;
    @Length(min = 3, max = 20, message = PASSWORD_LENGTH_MSG)
    private String password;
    private String confirmPassword;
    @Email(message = EMAIL_VALID_MSG)
    @NotBlank(message = EMAIL_VALID_MSG)
    private String email;

    public UserRegisterBindingModel() {
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
