package com.geek.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 分析性能问题。
 */
public class Test10 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test01();
        test02();
        test03();
    }

    // 普通方式调用。
    public static void test01() {
        User user = new User();

        long startTime = System.currentTimeMillis();

        // 10亿次。
        for (int i = 0; i < 100000000; i++) {
            user.getName();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("普通方式执行 10 亿次。" + (endTime - startTime) + "ms");
    }


    // 反射方式调用。
    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class<? extends User> aClass = user.getClass();

        Method getName = aClass.getDeclaredMethod("getName");

        long startTime = System.currentTimeMillis();

        // 10亿次。
        for (int i = 0; i < 100000000; i++) {
            getName.invoke(user);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("反射方式执行 10 亿次。" + (endTime - startTime) + "ms");
    }

    // 反射方式调用。关闭权限检测。
    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class<? extends User> aClass = user.getClass();

        Method getName = aClass.getDeclaredMethod("getName");
        getName.setAccessible(true);

        long startTime = System.currentTimeMillis();

        // 10亿次。
        for (int i = 0; i < 100000000; i++) {
            getName.invoke(user);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("关闭权限检测。反射方式执行 10 亿次。" + (endTime - startTime) + "ms");
    }
}
