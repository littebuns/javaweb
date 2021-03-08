package com.xxb.servlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@WebServlet("/user/down")
public class DownServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String realPath = this.getServletContext().getRealPath("WEB-INF/classes/images/1.jpg");
        String filename = realPath.substring(realPath.lastIndexOf("/") + 1);
        resp.setHeader("Content-Disposition", "attachment;filename=" + filename);
        //获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        //创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        ServletOutputStream out = resp.getOutputStream();
        //先将in流写入到缓冲区，然后再用out将缓冲区中的数据输出到客户端
        while ((len = in.read(buffer)) > 0){
            out.write(buffer, 0 , len);
        }
        in.close();
        out.close();

    }



}
