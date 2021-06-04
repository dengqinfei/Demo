package com.deng.demo.awareAndProcessor;

import com.deng.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserService(){
        System.out.println("实例化构造方法UserService");
    }

    public User save(User c){

        Long id = c.getUser();
        System.out.println("user:" + id);
        return c;

    }

}
