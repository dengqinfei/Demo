package com.deng.demo.bean;

import com.deng.demo.model.Tea;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanRegister implements CommandLineRunner {

    @Autowired
    private ApplicationContext appContext;

    @Override
    public void run(String... args) throws Exception {
        //获取context
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) appContext;
        //获取BeanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();
        //创建bean信息.
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Tea.class);
        String beanName = "tea";
        //所有的bean
       //for (String ss : appContext.getBeanDefinitionNames()){
       //    System.out.println(ss);
       //}
        //判断Bean是否已经注册
        Object beanObject = null;
        try {
            beanObject = appContext.getBean(beanName);
            System.out.println(String.format("Bean %s 已注册", beanName));
        } catch (BeansException e) {
            //动态注册bean.
            defaultListableBeanFactory.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
            //获取动态注册的bean.
            beanObject = appContext.getBean(beanName);
            if (beanObject != null) {
                System.out.println(String.format("Bean %s 注册成功", beanName));
            } else {

            }
        }

    }
}