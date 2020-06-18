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
public class addhomework extends HttpServlet {
    @RequestMapping("/homework")
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String n1 = req.getParameter("n1");
        String n2 = req.getParameter("n2");
        jdbc jd=new jdbc();
        jd.addhomework(n1,n2, user.username);
    }
}