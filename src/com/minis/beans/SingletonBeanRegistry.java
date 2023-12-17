package com.minis.beans;

/**
 * @author 滕广银
 * @description TODO
 * @date 2023/12/14 9:35
 */
public interface SingletonBeanRegistry {
    void registerSingleton(String beanName, Object singletonObject);

    Object getSingleton(String beanName);

    boolean containsSingleton(String beanName);

    String[] getSingletonNames();
}
