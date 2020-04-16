package com.geek.reflect;

import java.lang.annotation.*;
import java.lang.reflect.Field;

// 类名的注解。
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableGeek {
    String value();
}

// 属性的注解。
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldGeek {
    String columnName();

    String type();

    int length();
}


/**
 * 练习反射操作注解。
 */
public class Test12 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> aClass = Class.forName("com.geek.reflect.Student2");

        // 通过反射获得注解。
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation = " + annotation);
        }

        // 获得注解的 value 值。
        TableGeek tableGeek = aClass.getAnnotation(TableGeek.class);
        String value = tableGeek.value();
        System.out.println("value = " + value);

        // 获取类指定的注解。
        Field field = aClass.getDeclaredField("name");
        FieldGeek annotation = field.getAnnotation(FieldGeek.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());

        // annotation = @com.geek.reflect.TableGeek(value=db_Student)
        //value = db_Student
        //db_name
        //varchar
        //3
        //
        //Process finished with exit code 0
    }

}

@TableGeek("db_Student")
class Student2 {
    @FieldGeek(columnName = "db_id", type = "int", length = 10)
    private int id;
    @FieldGeek(columnName = "db_age", type = "int", length = 10)
    private int age;
    @FieldGeek(columnName = "db_name", type = "varchar", length = 3)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
