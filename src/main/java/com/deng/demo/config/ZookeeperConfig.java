package com.deng.demo.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ZookeeperConfig {
    @Autowired
    private Environment environment;


        @Bean(initMethod = "start")
        public CuratorFramework curatorFramework() {
            String zookeeperServer = environment.getRequiredProperty("zookeeper.server");

            return CuratorFrameworkFactory.newClient(zookeeperServer, new RetryNTimes(5, 1000));
        }




}
