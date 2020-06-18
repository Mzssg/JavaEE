package main.com.example.springbootdemo.servlet;

import main.com.example.springbootdemo.jdbc.jdbc;
import main.com.example.springbootdemo.model.user;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class addhomework extends HttpServlet {
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