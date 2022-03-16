package com.urbancompany.uber.services;

import com.urbancompany.uber.database.UserStorage;
import com.urbancompany.uber.models.User;

public class UserServiceImpl implements UserService{
    @Override
    public void registerUser(User user) {
        UserStorage.registerUser(user);
    }
}
