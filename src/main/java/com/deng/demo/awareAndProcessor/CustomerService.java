package com.deng.demo.awareAndProcessor;

import com.deng.demo.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public CustomerService(){
        System.out.println("实例化构造方法RoleService");
    }

    public Customer save(Customer c){

        String name = c.getName();
        System.out.println("Customer:" + name);
        return c;

    }

}
