package service;

import data.User;

public interface UserService {
    User login(String username, String password, UserType userType);
}
