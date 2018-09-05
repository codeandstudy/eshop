//package com.springboot.eshop.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import java.awt.*;
//import java.net.URI;
//
//@Component
//public class MyCommandRunner implements CommandLineRunner {
//    private static Logger logger = LoggerFactory.getLogger(MyCommandRunner.class);
//    @Value("${spring.web.loginurl}")
//    private String loginUrl;
//
//    @Value("${spring.web.googleexcute}")
//    private String googleExcutePath;
//
//    @Value("${spring.auto.openurl}")
//    private boolean isOpen;
//
//    @Override
//    public void run(String... args) throws Exception {
//        if(isOpen){
//            String cmd = googleExcutePath +" "+ loginUrl;
//            Runtime run = Runtime.getRuntime();
//            try{
//                run.exec(cmd);
//                logger.debug("启动浏览器打开项目成功");
//            }catch (Exception e){
//                e.printStackTrace();
//                logger.error(e.getMessage());
//            }
//        }
//    }
//}
