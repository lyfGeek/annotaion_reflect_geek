package com.geek.reflect;

public class ReflectionDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        // 通过反射获取类的 Class 对象。
        Class<?> c1 = Class.forName("com.geek.reflect.User");
        System.out.println("c1 = " + c1);
        // c1 = class com.geek.reflect.User

        Class<?> c2 = Class.forName("com.geek.reflect.User");
        Class<?> c3 = Class.forName("com.geek.reflect.User");

        // 一个类在内存中只有一个 Class 对象。
        // 一个类被加载后，类的整个结构都会被封装在 class 对象中。
        System.out.println(c1.hashCode());// 460141958
        System.out.println(c2.hashCode());// 460141958
        System.out.println(c3.hashCode());// 460141958

    }
}

// 实体类。
class User {
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    private void test() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
