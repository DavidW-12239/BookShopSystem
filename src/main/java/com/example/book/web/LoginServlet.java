package com.example.book.web;

import com.example.book.pojo.User;
import com.example.book.service.UserService;
import com.example.book.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //UserService处理登录
        User loginUser = userService.login(new User(null, username, password, null));

        if (loginUser == null){
            req.setAttribute("msg", "username or password error");
            req.setAttribute("username", username);

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
        else{
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }

    }
}
