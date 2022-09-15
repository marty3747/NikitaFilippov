package ru.training.at.hw3.projectUtils;

import ru.training.at.hw3.model.User;

import static ru.training.at.hw3_steps.data.UserData.getPassword;
import static ru.training.at.hw3_steps.data.UserData.getUsername;

public class CreateUser {
    public static User createUser() {
        return new User(getUsername(), getPassword());
    }
}
