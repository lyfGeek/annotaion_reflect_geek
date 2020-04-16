package com.geek.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test08 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class<?> aClass = Class.forName("com.geek.reflect.User");

        User user = new User();
        aClass = user.getClass();

        // 获取类的名字。
        System.out.println(aClass.getName());// com.geek.reflect.User
        System.out.println(aClass.getCanonicalName());
        System.out.println(aClass.getSimpleName());// User
        System.out.println(aClass.getTypeName());

        // 获得类的属性。
        System.out.println("～　～　～　～　～　～　～");
        Field[] fields = aClass.getFields();// public。
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("～　～　～　～　～　～　～");

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        // private java.lang.String com.geek.reflect.User.name
        //private int com.geek.reflect.User.id
        //private int com.geek.reflect.User.age

        // 获得指定属性的值。
        Field names = aClass.getDeclaredField("name");
        System.out.println("names = " + names);
        // names = private java.lang.String com.geek.reflect.User.name

        System.out.println("～　～　～　～　～　～　～");

        // 获得类的方法。
        Method[] methods = aClass.getMethods();
        System.out.println("methods = " + methods);// 本类 + 父类。
        for (Method method : methods) {
            System.out.println("method = " + method);
        }
        // methods = [Ljava.lang.reflect.Method;@74a14482
        //method = public java.lang.String com.geek.reflect.User.toString()
        //method = public java.lang.String com.geek.reflect.User.getName()
        //method = public int com.geek.reflect.User.getId()
        //method = public void com.geek.reflect.User.setName(java.lang.String)
        //method = public void com.geek.reflect.User.setAge(int)
        //method = public void com.geek.reflect.User.setId(int)
        //method = public int com.geek.reflect.User.getAge()
        //method = public final void java.lang.Object.wait() throws java.lang.InterruptedException
        //method = public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
        //method = public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
        //method = public boolean java.lang.Object.equals(java.lang.Object)
        //method = public native int java.lang.Object.hashCode()
        //method = public final native java.lang.Class java.lang.Object.getClass()
        //method = public final native void java.lang.Object.notify()
        //method = public final native void java.lang.Object.notifyAll()

        Method[] declaredMethods = aClass.getDeclaredMethods();
        System.out.println("declaredMethods = " + declaredMethods);
        // declaredMethods = [Ljava.lang.reflect.Method;@74a14482
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod = " + declaredMethod);// 本类。
        }
        // declaredMethods = [Ljava.lang.reflect.Method;@1540e19d
        //declaredMethod = public java.lang.String com.geek.reflect.User.toString()
        //declaredMethod = public java.lang.String com.geek.reflect.User.getName()
        //declaredMethod = public int com.geek.reflect.User.getId()
        //declaredMethod = public void com.geek.reflect.User.setName(java.lang.String)
        //declaredMethod = private void com.geek.reflect.User.test()
        //declaredMethod = public int com.geek.reflect.User.getAge()
        //declaredMethod = public void com.geek.reflect.User.setAge(int)
        //declaredMethod = public void com.geek.reflect.User.setId(int)

        // 获得指定方法。
        Method getName = aClass.getMethod("getName");
        Method setName = aClass.getMethod("setName", String.class);
        System.out.println("getName = " + getName);
        // getName = public java.lang.String com.geek.reflect.User.getName()
        System.out.println("setName = " + setName);
        // setName = public void com.geek.reflect.User.setName(java.lang.String)

        // 获得指定构造器。
        System.out.println("～　～　～　～　～　～　～");
        Constructor<?>[] constructors = aClass.getConstructors();
        System.out.println("constructors = " + constructors);
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("declaredConstructor = " + declaredConstructor);
        }
        // constructors = [Ljava.lang.reflect.Constructor;@677327b6
        //declaredConstructor = public com.geek.reflect.User()
        //declaredConstructor = public com.geek.reflect.User(java.lang.String,int,int)

        // 获得指定参数构造器。
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println("declaredConstructor = " + declaredConstructor);
    }
}
