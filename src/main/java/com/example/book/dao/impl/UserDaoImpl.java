package com.example.book.dao.impl;

import com.example.book.dao.UserDao;
import com.example.book.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryByUserName(String userName) {
        String sql = "select `id`, `username`, `password`, `email` from t_user where username = ?";
        return queryForOne(User.class, sql, userName);
    }

    @Override
    public User queryByUserNameAndPassword(String userName, String password) {
        String sql = "select `id`, `username`, `password`, `email` from t_user where username = ? and password = ?";
        return queryForOne(User.class, sql, userName, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`, `password`, `email`) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }


}
