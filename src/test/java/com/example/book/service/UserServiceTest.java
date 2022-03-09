package com.example.book.service;

import com.example.book.pojo.User;
import com.example.book.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    void registerUser() {
        userService.registerUser(new User(null, "ccj168", "66666", "123@ee.com"));
    }

    @Test
    void login() {
        System.out.println(userService.login(new User(null, "ccj168", "66666", "123@ee.com")));
    }

    @Test
    void existsUserName() {
        if(userService.existsUserName("ccj168")){
            System.out.println("exist");
        }
        else{
            System.out.println("available");
        }
    }
}