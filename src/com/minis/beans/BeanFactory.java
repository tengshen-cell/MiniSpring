package com.minis.beans;

/**
 * @author 滕广银
 * @description TODO
 * @date 2023/11/30 10:31
 */
public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;

    void registerBeanDefinition(BeanDefinition beanDefinition);

    void registerBean(String beanName, Object obj);
    Boolean containsBean(String name);

    boolean isSingleton(String name);

    boolean isPrototype(String name);

    Class<?> getType(String name);
}
