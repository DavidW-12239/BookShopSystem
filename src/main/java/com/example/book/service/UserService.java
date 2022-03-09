package com.example.book.service;

import com.example.book.pojo.User;

public interface UserService {

    public void registerUser(User user);

    public User login(User user);

    public boolean existsUserName(String username);


}
