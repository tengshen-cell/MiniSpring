package com.minis.core;

/**
 * @author 滕广银
 * @description TODO
 * @date 2023/12/14 10:32
 */
public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}
