package com.geek.reflect;

/**
 * 测试 Class 类的创建方式。
 */
public class DemoClass {

    public static void main(String[] args) {
        Person person = new Student();
        System.out.println("the person is: " + person.name);

        // 方式 1：通过对象获取。
        Class<? extends Person> aClass = person.getClass();
        System.out.println(aClass.hashCode());// 460141958

        // 方式 2：forName() 获取。
        try {
            Class<?> aClass1 = Class.forName("com.geek.reflect.Student");
            System.out.println(aClass1.hashCode());// 460141958
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 方式 3：通过 `类名.class` 获得。
        Class<Student> aClass1 = Student.class;
        System.out.println(aClass1.hashCode());// 460141958

        // 基本内置类型的包装类都有一个 Type 属性。
        Class<Integer> aClass2 = Integer.TYPE;
        System.out.println("aClass2 = " + aClass2);// int
        Class<Integer> integerClass = int.class;
        System.out.println("integerClass = " + integerClass);// int

        // 获得父类类型。
        Class<?> superclass = aClass.getSuperclass();
        System.out.println("superclass = " + superclass);// superclass = class com.geek.reflect.Person

    }

}


class Person {
    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

}

class Student extends Person {
    public Student() {
//        super();
        this.name = "学生";
    }
}

class Teacher extends Person {
    public Teacher() {
        this.name = "老师";
    }
}
