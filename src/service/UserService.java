package service;

import data.User;

public interface UserService {
    User createUser(User user);

    User getUserById(int userId);

    boolean updateUser(User user);

    boolean deleteUser(int userId);
}
