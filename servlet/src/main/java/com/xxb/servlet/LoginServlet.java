package com.xxb.servlet;

import com.xxb.entity.Constant;
import com.xxb.entity.Result;
import com.xxb.service.UserService;
import com.xxb.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
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
            UserService service = new UserServiceImpl();
            Result result = service.checkUser(username, pwd);
            if (result.isSuccess()){
                //登录成功，把用户名放入seesion中
                req.getSession().setAttribute(Constant.USER_SEESION, result.getData());
                //将登录时间保存在cookie
                Date date = new Date();
                Cookie cookie = new Cookie("lastLoginTime", URLEncoder.encode(date.toString(), "utf-8"));
                resp.addCookie(cookie);
                resp.sendRedirect("/jsp/index.jsp");
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
