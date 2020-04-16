package com.geek.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    // 注解的参数：参数类型 + 参数名();
    String name() default "";

    int age() default 0;

    int id() default -1;// 默认值 -1，代表不存在。

    String[] schools() default {"清华", "北大"};
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3 {

    String value();

}

public class Demo02 {

    @MyAnnotation2(name = "Geek", schools = "aaa")
    public void test() {

    }

    @MyAnnotation3("geek")// 只有一个 value，可以省略。
    public void test02() {

    }
}
