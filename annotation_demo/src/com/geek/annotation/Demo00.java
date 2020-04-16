package com.geek.annotation;

public class Demo00 {
    @SuppressWarnings("all")
    @Deprecated
    public static void test() {
        System.out.println("Deprecated.");
    }

    public static void main(String[] args) {
        test();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
