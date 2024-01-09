package com.minis.beans;

import com.minis.beans.factory.config.BeanDefinition;

/**
 * @author 滕广银
 * @description TODO
 * @date 2023/12/14 11:05
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String name, BeanDefinition bd);

    void removeBeanDefinition(String name);

    BeanDefinition getBeanDefinition(String name);

    boolean containsBeanDefinition(String name);
}
