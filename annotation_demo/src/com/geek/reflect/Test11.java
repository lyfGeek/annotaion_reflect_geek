package com.geek.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 通过反射获取泛型。
 */
public class Test11 {

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test11.class.getMethod("test01", Map.class, List.class);

        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("#genericParameterType = " + genericParameterType);

            // #genericParameterType = java.util.Map<java.lang.String, com.geek.reflect.User>
            //actualTypeArgument = class java.lang.String
            //actualTypeArgument = class com.geek.reflect.User
            //#genericParameterType = java.util.List<com.geek.reflect.User>
            //actualTypeArgument = class com.geek.reflect.User

            if (genericParameterType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("actualTypeArgument = " + actualTypeArgument);
                }
            }
        }

        System.out.println("～　～　～　～　～　～　～");

        Method method2 = Test11.class.getMethod("test02");
        Type genericReturnType = method2.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("actualTypeArgument = " + actualTypeArgument);
            }
        }

        // actualTypeArgument = class java.lang.String
        //actualTypeArgument = class com.geek.reflect.User
    }

    public void test01(Map<String, User> map, List<User> list) {
        System.out.println("test01");
    }

    public Map<String, User> test02() {
        System.out.println("test02");
        return null;
    }
}
