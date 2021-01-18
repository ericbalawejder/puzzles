package com.exercises;

public class Human {
    public static void main(String...args) {

    }

    private String name;
    private int age;

    Human(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    static int compareByNameThenByAge(Human lhs, Human rhs) {
        if (lhs.name.equals(rhs.name)) {
            return lhs.age - rhs.age;
        } else {
            return lhs.name.compareTo(rhs.name);
        }
    }

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
