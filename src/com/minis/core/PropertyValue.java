package com.minis.core;

/**
 * @author 滕广银
 * @description TODO
 * @date 2023/12/14 10:42
 */
public class PropertyValue {

    private final String type;
    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value, String type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public String getType() {
        return this.type;
    }
}
