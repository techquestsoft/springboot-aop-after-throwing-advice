package com.training.springboot.aop.afterthrowing;

import com.training.springboot.aop.afterthrowing.model.Account;
import com.training.springboot.aop.afterthrowing.service.impl.AccountService;
import com.training.springboot.aop.afterthrowing.service.impl.AccountServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringbootAopAfterThrowingAdviceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ac = SpringApplication.run(SpringbootAopAfterThrowingAdviceApplication.class, args);
//Fetching the account object from the application context
        AccountService accountService = ac.getBean("accountServiceImpl", AccountServiceImpl.class);
        Account account;
        try {
            account = accountService.getAccountByCustomerId("K2434567");
            if (account != null)
                System.out.println(account.getAccountNumber() + "\t" + account.getAccountType());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
//generating exception
            account = accountService.getAccountByCustomerId(null);
            if (account != null)
                System.out.println(account.getAccountNumber() + "\t" + account.getAccountType());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
