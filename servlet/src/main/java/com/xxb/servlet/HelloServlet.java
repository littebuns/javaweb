package com.xxb.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * @author HP
 */
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String user = (String) req.getSession().getAttribute("user");
        String time = "";
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if ("lastLoginTime".equals(cookie.getName())){
                time = cookie.getValue();
                break;
            }
        }
        out.write("Hello " + user + "!"+ "\n");
        out.write( "上次的登录时间为：" + URLDecoder.decode(time, "utf-8"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
