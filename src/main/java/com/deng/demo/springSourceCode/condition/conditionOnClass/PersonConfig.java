package com.deng.demo.springSourceCode.condition.conditionOnClass;

import com.deng.demo.springSourceCode.condition.Person;
import com.deng.demo.springSourceCode.condition.Student;
import com.deng.demo.springSourceCode.condition.Teacher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("PersonConfig2")
class PersonConfig {
    @ConditionalOnClass(Person.class)
    @Bean
    public Person student1(){
        System.out.println("student1");
        Student stu = new Student();
        return stu;
    }

    @Bean
    public Person teacher1(){
        System.out.println("teacher1");
        Teacher tea =  new Teacher();
        return tea;

    }
}
