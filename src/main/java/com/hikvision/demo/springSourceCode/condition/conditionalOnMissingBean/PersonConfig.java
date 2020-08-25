package com.hikvision.demo.springSourceCode.condition.conditionalOnMissingBean;

import com.hikvision.demo.springSourceCode.condition.Person;
import com.hikvision.demo.springSourceCode.condition.Student;
import com.hikvision.demo.springSourceCode.condition.Teacher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("personConfig3")
class PersonConfig {

    @ConditionalOnMissingBean(Person.class)
    @Bean
    public Person student3(){
        System.out.println("student3");
        Student stu = new Student();
        return stu;
    }

    @Bean
    public Person teacher3(){
        System.out.println("teacher3");
        Teacher tea =  new Teacher();
        return tea;

    }
}
