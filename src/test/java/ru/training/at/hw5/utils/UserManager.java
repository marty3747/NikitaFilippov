package ru.training.at.hw5.utils;

import static ru.training.at.hw5.data.UserData.getPassword;
import static ru.training.at.hw5.data.UserData.getUserName;
import ru.training.at.hw5.model.User;

public class UserManager {
    public static User createUser() {
        return new User(getUserName(), getPassword());
    }
}
