package main.com.example.springbootdemo.servlet;

import main.com.example.springbootdemo.jdbc.jdbc;
import main.com.example.springbootdemo.model.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class applyhomework extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String answer = req.getParameter("answer");
        String homework = req.getParameter("homework");
        jdbc jd=new jdbc();
        jd.applyhomework(homework,answer,user.username);

    }
}
