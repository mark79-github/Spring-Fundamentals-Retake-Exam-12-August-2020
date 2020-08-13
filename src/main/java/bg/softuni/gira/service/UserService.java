package bg.softuni.gira.service;

import bg.softuni.gira.model.service.UserServiceModel;

import java.util.Optional;

public interface UserService {
    UserServiceModel getUserByName(String username);

    UserServiceModel getUserByEmail(String email);

    void addUser(UserServiceModel userServiceModel);
}
