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
    private final boolean isRef;

    public PropertyValue(String name, String type, Object value, boolean isRef) {
        this.name = name;
        this.value = value;
        this.type = type;
        this.isRef = isRef;
    }

    public PropertyValue(String type, String name, Object value) {
        this(type, name, value, false);
    }

    public PropertyValue(String name, Object value) {
        this("", name, value,false);
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

    public Boolean getIsRef() {
        return isRef;
    }
}
