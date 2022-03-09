package com.example.book.dao;

import com.example.book.pojo.User;

public interface UserDao {

    public User queryByUserName(String userName);

    public User queryByUserNameAndPassword(String userName, String password);

    public int saveUser(User user);

}


