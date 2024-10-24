package service.impl;

import data.User;
import data.dao.Storage;
import service.UserService;
import service.UserType;

public class UserServiceImpl implements UserService {

    @Override
    public User login(String username, String password, UserType userType) {

        return Storage.getUserByEmailAndPassword(username, password, userType);
    }


}
