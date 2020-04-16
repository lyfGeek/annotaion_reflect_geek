package com.geek.reflect;

public class Test05 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
    }

}

class A {
    static int m = 666;

    static {
        System.out.println("A 类静态代码块初始化。");
        m = 300;
    }

    public A() {
        System.out.println("A 类的无参构造初始化。");
    }
}
