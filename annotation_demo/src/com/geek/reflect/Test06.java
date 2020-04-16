package com.geek.reflect;

/**
 * 测试类什么时候会初始化。
 */
public class Test06 {

    static {
        System.out.println("main 类被加载。");
    }

    public static void main(String[] args) {
        // 主动引用。
//        Son son = new Son();
        /*
        main 类被加载。
父类被加载。
子类被加载。

Process finished with exit code 0

         */

        // 反射也会产生主动引用。
/*
        try {
            Class.forName("com.geek.reflect.Son");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
*/

        // 不会产生类的引用方法。
//        System.out.println(Son.b);
        /*
        main 类被加载。
        父类被加载。
        2
                */

//        Son[] sons = new Son[5];
        // main 类被加载。

        System.out.println(Son.M);
        // main 类被加载。
        //1
    }
}


class Father {

    static int b = 2;

    static {
        System.out.println("父类被加载。");
    }
}


class Son extends Father {

    static final int M = 1;
    static int m = 100;

    static {
        System.out.println("子类被加载。");
        m = 300;
    }
}
