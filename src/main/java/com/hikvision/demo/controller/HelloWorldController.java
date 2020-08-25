package com.hikvision.demo.controller;

import com.deng.demosdkconfig.bic.BicCoreService;
import com.hikvision.demo.model.Config;
import com.hikvision.demo.model.HelloWorldRequestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class HelloWorldController {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
    @Autowired
    private Environment en;
    @Autowired
    private BicCoreService bicCoreService;
    @PostMapping("/postValue")
    public HelloWorldRequestModel postParam(@RequestBody HelloWorldRequestModel helloWorldRequest){
        List<Config> configs = helloWorldRequest.getConfigs();
        for (Config config : configs){
            logger.info("{},{}",config.getKey(),config.getValue());
        }
        return helloWorldRequest;
    }

    @GetMapping("/getValue")
    public String getParam(HttpServletRequest request, HttpServletResponse response){
        String name = en.getProperty("demo.data.name");
        String value = en.getProperty("demo.data.value");
        return name + ":" + value;
    }
    @GetMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = new Cookie("key","value");
        cookie.setPath("/demo");
        response.addCookie(cookie);
        bicCoreService.getNodesListByServiceInfo("cluster","proxy","");
        logger.info("request.getRequestURL()::"+ request.getRequestURL().toString());
        logger.info("request.getRequestURI()::"+request.getRequestURI());
        logger.info("request.getHeader(\"X-Real-IP\")::"+request.getHeader("X-Real-IP"));
        logger.info("request.getHeader(\"Host\")::"+request.getHeader("Host"));
        logger.info("request.getHeader(\"X-Forwarded-For\")::"+request.getHeader("X-Forwarded-For"));
        logger.info("request.getHeader(\"X-Forwarded-Proto\")::"+request.getHeader("X-Forwarded-Proto"));
        logger.info(request.getParameter("i"));
       // logger.info(request.getParameter("pid"));
      //  logger.info(request.getParameter("url"));
      //  logger.info(request.getParameter("bid"));
      //  logger.info(request.getParameter("ptime"));
        System.out.printf("111111111111111111111111122222221");
        return "success";
    }

    @GetMapping("/hello3minTimeOut")
    public String hello3minTimeOut(HttpServletRequest request, HttpServletResponse response){
        logger.info(request.getRequestURL().toString());
        logger.info(request.getRequestURI());
        logger.info(request.getParameter("i"));
        logger.info(request.getParameter("pid"));
        logger.info(request.getParameter("url"));
        logger.info(request.getParameter("bid"));
        logger.info(request.getParameter("ptime"));
        try {
            Thread.sleep(3*60*1000+40*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("111111111111111111111111122222221");
        return "3minsuccess";
    }

    @GetMapping("/hello4minTimeOut")
    public String hello4minTimeOut(HttpServletRequest request, HttpServletResponse response){
        logger.info(request.getRequestURL().toString());
        logger.info(request.getRequestURI());
        logger.info(request.getParameter("i"));
        logger.info(request.getParameter("pid"));
        logger.info(request.getParameter("url"));
        logger.info(request.getParameter("bid"));
        logger.info(request.getParameter("ptime"));
        try {
        //    Thread.sleep(4*60*1000+40*1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("111111111111111111111111122222221");
        return "4minsuccess";
    }



}
