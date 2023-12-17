package com.minis.core;

import java.util.EventObject;

/**
 * @author 滕广银
 * @description TODO
 * @date 2023/12/14 10:33
 */
public class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
