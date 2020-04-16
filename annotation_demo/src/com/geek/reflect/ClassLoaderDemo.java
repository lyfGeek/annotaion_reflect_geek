package com.geek.reflect;

public class ClassLoaderDemo {

    public static void main(String[] args) throws ClassNotFoundException {

        // 获取系统类加载器。
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("systemClassLoader = " + systemClassLoader);
        // systemClassLoader = sun.misc.Launcher$AppClassLoader@18b4aac2

        // 获取系统类加载器的父类加载器 ——> 扩展类加载器。
        ClassLoader systemClassLoaderParent = systemClassLoader.getParent();
        System.out.println("systemClassLoaderParent = " + systemClassLoaderParent);
        // systemClassLoaderParent = sun.misc.Launcher$ExtClassLoader@1b6d3586

        // 获取扩展类加载器的父类加载器 ——> 根加载器（C / C++）。
        ClassLoader parent = systemClassLoaderParent.getParent();
        System.out.println("parent = " + parent);
        // null。

        ClassLoader classLoader = Class.forName("com.geek.reflect.ClassLoaderDemo").getClassLoader();
        System.out.println("classLoader = " + classLoader);
        // classLoader = sun.misc.Launcher$AppClassLoader@18b4aac2

        // jdk 内置类。
        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println("classLoader1 = " + classLoader1);
        // null。

        // 获取系统类加载器可以加载的路径。
        System.out.println(System.getProperty("java.class.path"));

        // /home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/charsets.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/deploy.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/ext/cldrdata.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/ext/dnsns.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/ext/jaccess.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/ext/jfxrt.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/ext/localedata.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/ext/nashorn.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/ext/sunec.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/ext/sunjce_provider.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/ext/sunpkcs11.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/ext/zipfs.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/javaws.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/jce.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/jfr.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/jfxswt.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/jsse.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/management-agent.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/plugin.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/resources.jar:/home/geek/geek/tools_my/jdk1.8.0_241/jre/lib/rt.jar:/home/geek/IdeaProjects/reflect_geek/out/production/reflect_geek:/home/geek/geek/tools_my/idea-IU-183.6156.11/lib/idea_rt.jar

        // G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\charsets.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\deploy.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\ext\access-bridge-64.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\ext\cldrdata.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\ext\dnsns.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\ext\jaccess.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\ext\jfxrt.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\ext\localedata.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\ext\nashorn.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\ext\sunec.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\ext\sunjce_provider.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\ext\sunmscapi.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\ext\sunpkcs11.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\ext\zipfs.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\javaws.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\jce.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\jfr.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\jfxswt.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\jsse.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\management-agent.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\plugin.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\resources.jar;G:\lyfGeek\ProgramFiles\Java\jdk1.8.0_241\jre\lib\rt.jar;G:\lyfGeek\IdeaProjects\annotation_and_reflect\out\production\annotation_demo;G:\lyfGeek\Program Files\JetBrains\IntelliJ IDEA 2018.3.6\lib\idea_rt.jar
    }
}
