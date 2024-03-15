package com.core.residence.model;
public class RoomRequest {
    private String name;
    private int age;

    // Constructor
    public RoomRequest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters y setters (pueden ser generados automáticamente por tu IDE)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
