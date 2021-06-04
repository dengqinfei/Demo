package com.deng.demo;

import com.deng.demo.model.Customer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestMain {

    @Test
    public void test1(){

        System.out.println(System.currentTimeMillis());

        System.out.println(new Date(System.currentTimeMillis()));

        long ss = 1597650351972L;
        System.out.println(new Date(ss));

        long ss1 = 1597650558999L;
        System.out.println(new Date(ss1));

    }

    @Test
    public void test2(){
        Customer customer = new Customer();
        customer.setName("dsd");
       List<String> ss = new ArrayList<>();
       ss.add("fsf");
       ss.add("dsdsd");
        System.out.println(ss);
        System.out.println(customer);

        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("dsd","dsd");
        System.out.println(map);

    }

    @Test
    public void test3(){
        String cc = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(cc);
    }

}
