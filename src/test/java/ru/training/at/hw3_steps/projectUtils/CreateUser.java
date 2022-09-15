package ru.training.at.hw3_steps.projectUtils;

import static ru.training.at.hw3_steps.data.UserData.getPassword;
import static ru.training.at.hw3_steps.data.UserData.getUsername;

import ru.training.at.hw3_steps.model.User;

public class CreateUser {
    public static User createUser() {
        return new User(getUsername(), getPassword());
    }
}
