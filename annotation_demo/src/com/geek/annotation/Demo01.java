package com.geek.annotation;

import java.lang.annotation.*;

// 定义一个注解。
// @Target。表示注解可以用在哪些地方。
//方法和类上。
@Target(value = {ElementType.METHOD, ElementType.TYPE})
// @Retention。表示我们的注解在什么地方还有效。
// n.保持；维持；保留；（液体、热量等的）保持，阻滞；记忆力；记性
@Retention(value = RetentionPolicy.RUNTIME)// runtime > class > sources
// @Documented。将注解生成在 javadoc 中。
@Documented
// @Inherited。子类可以继承父类的注解。
@Inherited
@interface MyAnnotation {

}

/**
 * 测试元注解。
 */
public class Demo01 {
}
