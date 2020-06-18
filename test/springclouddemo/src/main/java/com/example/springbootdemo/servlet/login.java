package com.example.springbootdemo.servlet;

import com.example.springbootdemo.jdbc.jdbc;
import com.example.springbootdemo.model.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Controller
public class login extends HttpServlet {
    @RequestMapping("/index")
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("username");
        String pwd = req.getParameter("password");
        jdbc jd=new jdbc();

        if(jd.login(name,pwd)==1){
            user.username=name;
            user.type=jd.login(name,pwd);
            req.getRequestDispatcher("WEB-INF/jsp/student.jsp").forward(req, resp);
        }else if(jd.login(name,pwd)==2){
            user.username=name;
            user.type=jd.login(name,pwd);
            req.getRequestDispatcher("WEB-INF/jsp/addhomework.jsp").forward(req, resp);
        }else{
            System.out.println("登录失败！");
        }
    }
}
