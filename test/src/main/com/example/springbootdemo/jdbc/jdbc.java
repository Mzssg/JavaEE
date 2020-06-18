package main.com.example.springbootdemo.jdbc;

import main.com.example.springbootdemo.model.addhomeworkmodel;
import main.com.example.springbootdemo.model.applymodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class jdbc {
    public static int login(String username, String password) {
        String dbName = "javaee";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String jdbcUrl = "jdbc:mysql://localhost:3306/"+dbName+"?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
        String userName = "root";
        String userPwd = "20000218mazhe";
        String sql="select * from login";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcUrl,userName,userPwd);
            System.out.println("创建连接成功");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                if(rs.getString(1).equals(username)){
                    if(rs.getString(2).equals(password)){
                        return rs.getInt(3);
                    }
                    return 3;
                }
            }
            return 4;
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
            return 5;
        }
    }
    public static boolean registered(String username, String password, int type) {
        String dbName = "javaee";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String jdbcUrl = "jdbc:mysql://localhost:3306/"+dbName+"?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
        String userName = "root";
        String userPwd = "20000218mazhe";
        String sql="insert into login(username,password,type) values ('"+username+"','"+password+"','"+type+"')";
        try {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(jdbcUrl,userName,userPwd);
            System.out.println("创建连接成功");
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            return  true;
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
            return false;
        }
    }
    public static boolean addstudent(String studentname, String teachername) {
        String dbName = "javaee";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String jdbcUrl = "jdbc:mysql://localhost:3306/"+dbName+"?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
        String userName = "root";
        String userPwd = "20000218mazhe";
        String sql="select * from addstudent";
        String sql1="insert into addstudent (student,teacher) values('"+studentname+"','"+teachername+"')";
        try {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(jdbcUrl,userName,userPwd);
            System.out.println("创建连接成功");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                if(rs.getString(1).equals(studentname)&& rs.getString(2).equals(teachername)){
                    return false;
                }
            }
            statement.executeUpdate(sql1);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
            return false;
        }
    }
    public static boolean addhomework(String homeworkname, String homework, String teachername) {
        String dbName = "javaee";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String jdbcUrl = "jdbc:mysql://localhost:3306/"+dbName+"?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
        String userName = "root";
        String userPwd = "20000218mazhe";
        String sql="select * from homework";
        String sql1="insert into homework (homeworkname,homework,teachername) values('"+homeworkname+"','"+homework+"','"+teachername+"')";
        try {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(jdbcUrl,userName,userPwd);
            System.out.println("创建连接成功");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                if(rs.getString(1).equals(homeworkname)){
                    return false;
                }
            }
            statement.executeUpdate(sql1);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
            return false;
        }
    }
    public static boolean applyhomework(String homeworkname, String answer, String student) {
        String dbName = "javaee";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String jdbcUrl = "jdbc:mysql://localhost:3306/"+dbName+"?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
        String userName = "root";
        String userPwd = "20000218mazhe";
        String sql="select * from applyhomework";
        String sql1="insert into applyhomework (homeworkname,answer,student) values('"+homeworkname+"','"+answer+"','"+student+"')";
        try {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(jdbcUrl,userName,userPwd);
            System.out.println("创建连接成功");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            statement.executeUpdate(sql1);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
            return false;
        }
    }
    public static List<applymodel> teacherhomework(String teachername) {
        String dbName = "javaee";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String jdbcUrl = "jdbc:mysql://localhost:3306/"+dbName+"?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
        String userName = "root";
        String userPwd = "20000218mazhe";
        String sql1="select * from addstudent where teacher='"+teachername+"'";
        List<applymodel> list = new ArrayList<>();
        try {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(jdbcUrl,userName,userPwd);
            System.out.println("创建连接成功");
            Statement statement = conn.createStatement();
            Statement statement1 = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql1);

            while (rs.next()){
                String student=rs.getString(1);
                String sql="select * from applyhomework where student='"+student+"'";
                ResultSet rs1 = statement1.executeQuery(sql);
                while(rs1.next()){
                    applymodel l=new applymodel();
                    l.sethomeworkname(rs1.getString(1));
                    l.setanswer(rs1.getString(2));

                    l.setstudent(rs1.getString(3));
                    list.add(l);
                }
            }

            return list;
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
            return null;
        }
    }
    public static List<addhomeworkmodel> studenthomework(String student) {
        String dbName = "javaee";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String jdbcUrl = "jdbc:mysql://localhost:3306/"+dbName+"?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
        String userName = "root";
        String userPwd = "20000218mazhe";
        String sql0="select * from addstudent where student='"+student+"'";
        List<addhomeworkmodel> list = new ArrayList<>();
        try {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(jdbcUrl,userName,userPwd);
            System.out.println("创建连接成功");
            Statement statement = conn.createStatement();
            Statement statement1 = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql0);

            while (rs.next()){
                String teachername=rs.getString(2);
                String sql="select * from homework where teachername='"+teachername+"'";
                ResultSet rs1 = statement1.executeQuery(sql);
                while(rs1.next()){
                    list.add(new addhomeworkmodel(rs1.getString(1),rs1.getString(2),rs1.getString(3)));
                }
            }
            return list;
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
            return null;
        }
    }
}