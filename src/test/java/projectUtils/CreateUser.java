package projectUtils;

import model.User;

import static data.UserData.getPassword;
import static data.UserData.getUsername;

public class CreateUser {
    public static User createUser() {
        return new User(getUsername(), getPassword());
    }
}
