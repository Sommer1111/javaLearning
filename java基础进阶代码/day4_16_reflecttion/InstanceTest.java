package cn.code.day4_16_reflecttion;

import java.lang.reflect.Constructor;

/**
 * @Auther:sommer1111
 * @date 2020/4/18 11:44
 */
public class InstanceTest {
    //调用newInstance方法，创建运行时类对象，原理在于调用该类的空参构造器
    //这也是为什么自定义类必须提供空参构造器得原因，这样可以具体问题具体创建对象
    //也就有了反射得动态特性
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("cn.code.day4_16_reflecttion.Person");
        Person o1 = (Person) clazz.newInstance();
        //已经不建议使用，转而被clazz.getDeclaredConstructor().newInstance()取代

        Person o2 = (Person) clazz.getDeclaredConstructor().newInstance();
        System.out.println(o1);//Person{age=0, name='null', country='null'}
        System.out.println(o2);//Person{age=0, name='null', country='null'}

        
        /**
         * 通过类对象调用newInstance()方法，适用于无参构造方法：
         * 通过类对象的getConstructor()或getDeclaredConstructor()方法获得构造器（Constructor）对象
         * 调用其newInstance()方法创建对象，适用于无参和有参构造方法。
         * 如：String.class.getConstructor(String.class).newInstance(“Hello World”);
         * getDeclaredConstructor,这个方法会返回制定参数类型的所有构造器，包括public的和非public的，
         * getConstructor(Class<?>... parameterTypes),只返回制定参数类型访问权限是public的构造器。
         */
    }


}
