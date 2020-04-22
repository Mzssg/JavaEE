package main.java.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import main.java.jdbc.jdbc;
import main.java.model.user;

public class login extends HttpServlet{
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
            req.getRequestDispatcher("jsp/student.jsp").forward(req, resp);
        }else if(jd.login(name,pwd)==2){
            user.username=name;
            user.type=jd.login(name,pwd);
            req.getRequestDispatcher("jsp/addhomework.jsp").forward(req, resp);
        }else{
            System.out.println("登录失败！");
        }
    }
}
