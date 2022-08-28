package com.training.springboot.aop.afterthrowing.aspect;

import com.training.springboot.aop.afterthrowing.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspect {
    //implementing after returning advice
    @AfterReturning(value = "execution(* com.training.springboot.aop.afterthrowing.service.impl.AccountServiceImpl.*(..))", returning = "account")
    public void afterReturningAdvice(JoinPoint joinPoint, Account account) {
        System.out.println("After Returing method:" + joinPoint.getSignature());
        System.out.println(account);
    }

    //implementing after throwing advice
    @AfterThrowing(value = "execution(* com.training.springboot.aop.afterthrowing.service.impl.AccountServiceImpl.*(..))", throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
        System.out.println("After Throwing exception in method:" + joinPoint.getSignature());
        System.out.println("Exception is:" + ex.getMessage());
    }
}
