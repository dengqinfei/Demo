package com.hikvision.demo.controller;

import com.hikvision.demo.redis.RedisLock;
import com.hikvision.demo.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@RestController
public class RedisController {
    private static final Logger logger = LoggerFactory.getLogger(RedisController.class);
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private RedisLock redisLock;
    @GetMapping("/redis")
    public String hello(HttpServletRequest request, HttpServletResponse response){
        redisUtil.set("result","success");
        String result = (String) redisUtil.get("result");
        logger.info(result);
        return "success";
    }

    @GetMapping("/redisLock")
    public String lock(HttpServletRequest request, HttpServletResponse response){
        redisUtil.set("result","success");
        String result = (String) redisUtil.get("result");
        logger.info(result);

        boolean token = false;
        try{
            token = redisLock.secKilllock("lock_name", String.valueOf(System.currentTimeMillis()+60*1000));
            if(token ) {
                System.out.print("我拿到了锁哦");
                // 执行业务代码
            } else {
                System.out.print("我没有拿到锁唉");
            }
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(token) {
                redisLock.unlock("lock_name",null);
            }
        }
        return "success";
    }



}
