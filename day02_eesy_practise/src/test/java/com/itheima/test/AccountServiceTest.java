package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import config.Conf;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.swing.*;
import java.lang.reflect.Field;
import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Conf.class)
public class AccountServiceTest {
    @Autowired
    private IAccountService accountService;

//
//    @Before
//    public void  init() throws IllegalAccessException {
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Conf.class);
//        Field[] fields = this.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            Autowired annotation = field.getAnnotation(Autowired.class);
//            if(annotation!=null){
//                Class<?> type = field.getType();
//                Object bean = applicationContext.getBean(type);
//                field.setAccessible(true);
//                field.set(this,bean);
//            }
//        }
//
//    }





    @Test
    public void testFindAll() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(C);

        List<Account> accounts = accountService.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }

        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testFindOne() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        Account account = accountService.findAccountById(4);
        account.setMoney(23456f);
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        accountService.deleteAccount(4);
    }
}
