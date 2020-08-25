package com.hikvision.demo.controller;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

//@RestController
public class ZookeeperController {

    @Autowired
    private CuratorFramework curatorFramework;
    private static final Logger logger = LoggerFactory.getLogger(ZookeeperController.class);
    @GetMapping("/save/{name}")
    public String save(@PathVariable String name) {
        String keyPath = "/zktest" + name;

        try {

            // 获取锁
            InterProcessMutex balanceLock = new InterProcessMutex(curatorFramework, "/zktest" + name);
            if( balanceLock.acquire(5, TimeUnit.SECONDS)){

                try {
                    System.out.println("已经加锁了, name=" + name);
                    Thread.sleep(50000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        // 释放锁资源
                        balanceLock.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }else{
                System.out.println("获取锁失败, name=" + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取锁失败, name=" + name);
        }


        return "success";
    }

}
