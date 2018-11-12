package com.ngockhuong.springkafkaexample.non_spring;

import java.io.Serializable;

public class CustomObject implements Serializable {
    private String id;
    private String name;

    public CustomObject() {
    }

    public CustomObject(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomObject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
