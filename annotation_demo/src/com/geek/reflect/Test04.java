package com.geek.reflect;

import java.lang.annotation.ElementType;

/**
 * 所有类型的 Class。
 */
public class Test04 {

    public static void main(String[] args) {
        Class<Object> objectClass = Object.class;// 类。
        System.out.println("objectClass = " + objectClass);
        // class java.lang.Object

        Class<Comparable> comparableClass = Comparable.class;// 接口。
        System.out.println("comparableClass = " + comparableClass);
        // interface java.lang.Comparable

        Class<String[]> aClass = String[].class;// 数组。
        System.out.println("aClass = " + aClass);
        // class [Ljava.lang.String;

        Class<int[][]> aClass1 = int[][].class;// 二维数组。
        System.out.println("aClass1 = " + aClass1);
        // class [[I

        Class<Override> overrideClass = Override.class;// 注解。
        System.out.println("overrideClass = " + overrideClass);
        // interface java.lang.Override

        Class<ElementType> elementTypeClass = ElementType.class;// 枚举。
        System.out.println("elementTypeClass = " + elementTypeClass);
        // class java.lang.annotation.ElementType

        Class<Integer> integerClass = Integer.class;// 基本数据类型。
        System.out.println("integerClass = " + integerClass);
        // class java.lang.Integer

        Class<Void> voidClass = void.class;// void。
        System.out.println("voidClass = " + voidClass);
        // void

        Class<Class> classClass = Class.class;// Class。
        System.out.println("classClass = " + classClass);
        // class java.lang.Class

        int[] a = new int[10];
        int[] b = new int[100];
        System.out.println("a = " + a.getClass().hashCode());
        System.out.println("b = " + b.getClass().hashCode());
        // a = 460141958
        //b = 460141958
        // 元素类型和维度一样。
    }
}
