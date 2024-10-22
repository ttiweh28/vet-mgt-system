package service.impl;

import data.User;
import data.dao.Storage;
import service.UserService;
import service.UserType;

public class UserServiceImpl implements UserService {
    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User getUserById(int userId) {
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(int userId) {
        return false;
    }

    @Override
    public User login(String username, String password, UserType userType) {

        return Storage.getUserByEmailAndPassword(username, password, userType);
    }


}
