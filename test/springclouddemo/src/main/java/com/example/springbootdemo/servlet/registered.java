package com.example.springbootdemo.servlet;

import com.example.springbootdemo.jdbc.jdbc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Controller
public class registered extends HttpServlet {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("username");
        String pwd = req.getParameter("password");
        String type = req.getParameter("type");
        jdbc jd=new jdbc();
        if(jd.login(name,pwd)==4){
            jd.registered(name,pwd, Integer.parseInt(type));
            req.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(req, resp);
        }else{
            System.out.println("注册失败！");
        }
    }
}
