package com.example.book.service.impl;

import com.example.book.dao.UserDao;
import com.example.book.dao.impl.UserDaoImpl;
import com.example.book.pojo.User;
import com.example.book.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryByUserNameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUserName(String username) {
        if (userDao.queryByUserName(username) == null){
            return false;
        }
        return true;
    }
}
