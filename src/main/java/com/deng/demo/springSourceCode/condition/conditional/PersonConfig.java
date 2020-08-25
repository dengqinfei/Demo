package com.hikvision.demo.springSourceCode.condition.conditional;

import com.hikvision.demo.springSourceCode.condition.Person;
import com.hikvision.demo.springSourceCode.condition.Student;
import com.hikvision.demo.springSourceCode.condition.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {

    @Conditional(Body.class)
    @Bean
    public Person student(){
        System.out.println("student");
        Student stu = new Student();
        return stu;
    }

    @Bean
    public Person teacher(){
        System.out.println("teacher");
        Teacher tea =  new Teacher();
        return tea;

    }
}
