package main.java.spring;

import main.java.service.JdbcService;
//import com.zaxxer.hikari.HikariDataSource;
import main.java.bean.TestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

@ComponentScan("code.*")
public class TestSpring {

    public static void main(String[] args){


//        AnnotationConfigApplicationContext context =
//               new AnnotationConfigApplicationContext(TestSpring.class);
//
//
//        context.scan("code.service.*");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //文件系统
        //ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");
        int n=1;
        while (n-->=0){
        TestBean service =context.getBean("testBean",TestBean.class);
            System.out.println(service.toString());

            JdbcService jdbcservice = context.getBean("jdbcService", JdbcService.class);
            jdbcservice.getById(100L);
        }


    }
}