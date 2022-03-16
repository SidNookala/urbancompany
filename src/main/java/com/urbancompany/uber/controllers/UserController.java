package com.urbancompany.uber.controllers;

import com.urbancompany.uber.models.Booking;
import com.urbancompany.uber.models.User;
import com.urbancompany.uber.services.UserService;
import com.urbancompany.uber.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {



    public void registerUser(User user){
        UserService userService = new UserServiceImpl();
        userService.registerUser(user);
    }


}
