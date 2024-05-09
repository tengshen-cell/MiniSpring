package com.minis.test;

import com.minis.beans.BeansException;
import com.minis.context.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * @author 滕广银
 * @description TODO
 * @date 2023/11/29 11:43
 */
public class Test1 {

    public static final Double FREE_BIG_COST = Double.valueOf(1000000);

    public BigDecimal a = BigDecimal.valueOf(100);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        AService aService;
        try {
            aService = (AService) ctx.getBean("aservice");
            aService.sayHello();
        } catch (BeansException e) {
            e.printStackTrace();
        }

        BigDecimal a = BigDecimal.valueOf(100);

        if (a.doubleValue()> FREE_BIG_COST) {
            System.out.println("真");
        } else {
            System.out.println("假");
        }

    }
}

