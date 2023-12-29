package com.minis.beans.factory;

import com.minis.beans.BeansException;

/**
 * @author 滕广银
 * @description TODO
 * @date 2023/11/30 10:31
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    boolean containsBean(String name);

    boolean isSingleton(String name);

    boolean isPrototype(String name);

    Class<?> getType(String name);
}
