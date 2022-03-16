package com.urbancompany.uber.database;

import com.urbancompany.uber.models.User;

import java.util.HashMap;
import java.util.HashSet;

public class UserStorage {
    private static HashMap<String ,User> usersSet = new HashMap<>();

    public static HashMap<String ,User> getAllUsers(){
        return usersSet;
    }

    public static void registerUser(User user){
        usersSet.put(user.getId(), user);
    }
}
