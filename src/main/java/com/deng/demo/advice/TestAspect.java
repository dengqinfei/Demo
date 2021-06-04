package com.deng.demo.advice;

import com.deng.demo.model.Customer;
import com.deng.demo.model.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Component
@Aspect
public class TestAspect {



    @Around("execution(* com.deng.demo.awareAndProcessor.UserService.save(..))")
    public void userAround(ProceedingJoinPoint joinPoint) {
        Object[] arges = joinPoint.getArgs();
        for (Object arge : arges) {
            if (arge instanceof User) {
                User user = (User) arge;
                user.setUser(2L);
            }
        }
        try {
            Object o = joinPoint.proceed(arges);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("修改UserService");
    }

    @Around("execution(* com.deng.demo.awareAndProcessor.CustomerService.save(..))")
    public void customerAround(ProceedingJoinPoint joinPoint) {
        Object[] arges = joinPoint.getArgs();
        for (Object arge : arges) {
            if (arge instanceof Customer) {
                Customer customer = (Customer) arge;
                customer.setName("ds");
            }
        }
        try {
            Object o = joinPoint.proceed(arges);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("修改CustomerService");
    }

}
