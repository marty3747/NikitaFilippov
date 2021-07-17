package ru.training.at.hw4.projectUtils;

import static ru.training.at.hw3.data.UserData.getPassword;
import static ru.training.at.hw3.data.UserData.getUsername;

import ru.training.at.hw4.model.User;

public class CreateUser {
    public static User createUser() {
        return new User(getUsername(), getPassword());
    }
}
