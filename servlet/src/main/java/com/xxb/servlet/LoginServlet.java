package com.xxb.servlet;

import com.xxb.dao.BaseDao;
import com.xxb.dao.UserDao;
import com.xxb.dao.impl.UserDaoImpl;
import com.xxb.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private Map<String, String> userMap = new HashMap<String, String>(){
        {
            put("admin", "123");
        }
    };

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String pwd = req.getParameter("password");
        try {
            UserDao userDao = new UserDaoImpl();
            Connection connection = BaseDao.getConnection();
            User user = userDao.listUserByName(username, connection);
            if (user != null && user.getPassword().equals(pwd)){
                //登录成功，把用户名放入seesion中
                req.getSession().setAttribute("user", username);
                //将登录时间保存在cookie
                Date date = new Date();
                Cookie cookie = new Cookie("lastLoginTime", URLEncoder.encode(date.toString(), "utf-8"));
                resp.addCookie(cookie);
                resp.sendRedirect("/hello");
            }else {
                resp.sendRedirect("login.jsp");
            }
        }catch (Exception e){
            resp.sendRedirect("login.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
