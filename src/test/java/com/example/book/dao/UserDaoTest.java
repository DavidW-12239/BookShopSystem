package com.example.book.dao;

import com.example.book.dao.impl.UserDaoImpl;
import com.example.book.pojo.User;
import org.junit.jupiter.api.Test;

class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    void queryByUserName() {
        if (userDao.queryByUserName("admn") == null){
            System.out.println("name available");
        }
        else{
            System.out.println("occupied!");
        }
    }

    @Test
    void queryByUserNameAndPassword() {
        if (userDao.queryByUserNameAndPassword("admin", "admin") == null){
            System.out.println("login failed");
        }
        else{
            System.out.println("login successfully");
        }
    }

    @Test
    void saveUser() {
        System.out.println(userDao.saveUser(new User(null, "czb168", "3212131", "123@qq.com")));
    }
}