package com.geek.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射动态创建对象。
 */
public class Test09 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        // 获得 Class 对象。
        Class<?> aClass = Class.forName("com.geek.reflect.User");
        // 构造一个对象。
        // 本质调用无参构造器。
        User user = (User) aClass.newInstance();
        System.out.println("user = " + user);

        // 通过构造器创建对象。
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User) declaredConstructor.newInstance("Geek", 1, 18);
        System.out.println("user2 = " + user2);
        // user2 = User{name='Geek', id=1, age=18}

        // 通过反射调用方法。
        User user3 = (User) aClass.newInstance();
        Method setName = aClass.getDeclaredMethod("setName", String.class);
        setName.invoke(user3, "李");
        System.out.println("user3 = " + user3);
        // user3 = User{name='李', id=0, age=0}

        // 通过反射操作属性。
        User user4 = (User) aClass.newInstance();
        Field name = aClass.getDeclaredField("name");

        name.setAccessible(true);
        // 不能直接操作私有属性。
        // 需要关闭程序的安全检测。

        name.set(user4, "李2");
        System.out.println("～　～　～　～　～　～　～");
        System.out.println(user4.getName());
        // Exception in thread "main" java.lang.IllegalAccessException: Class com.geek.reflect.Test09 can not access a member of class com.geek.reflect.User with modifiers "private"


    }
}
