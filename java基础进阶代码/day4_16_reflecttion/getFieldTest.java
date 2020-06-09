package cn.code.day4_16_reflecttion;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Auther:sommer1111
 * @date 2020/4/20 11:20
 */
public class getFieldTest {
    //操作运行时类的指定属性
    public static void main(String[] args) throws Exception {
        /**
         * 思路，将每一个对象当作一个框架，里面有各种各样的属性：动物类：有手、脚、眼睛等抽象的概念
         * 我们利用反射去获取这些抽象的属性：脚
         * 再拿起具体的对象，对脚进行设置，set（对象，具体值）
         * 区别在于，我是抽象的最高级，可以适用于所有的对象，
         * 相对于我们拿起每一个对象进行单独设置的话，显得低效而憨厚。
         *
         * ——————————————————这就是程序的魅力！！！也是一种哲学————————————————————————
         * 程序猿一称绝对是一种贬低。
         *
         */

        //1.获取我们需要得到的指定属性
        //获取运行时类，运行时类对象
        Class clazz = Class.forName("cn.code.day4_16_reflecttion.Person");
        Field p1 = clazz.getDeclaredField("age");

        //创建运行时类实例对象
        Person p = (Person) clazz.getDeclaredConstructor().newInstance();

        //获取的运行时类对象public属性,用set对实例对象进行设置
        p1.set(p,100);
        int o = (int) p1.get(p);
        System.out.println(o);


        //对运行时对象的私有属性进行设置
        Field name = clazz.getDeclaredField("name");
        //确保是可以改变的。
        name.setAccessible(true);
        name.set(p,"luccy");
        String o1 = (String) name.get(p);
        System.out.println(o1);

        Class clazz1 = Person.class;
        Field age = clazz1.getDeclaredField("age");
        Person p3 = new Person();
        age.set(p3,31);
        System.out.println(age.get(p3));

        //获取运行时类的方法,参数2指定形参的类型
        Method show = clazz1.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        //invoke()返回方法本身的返回值，如果是void，则返回null
        Object jussy = show.invoke(p3, "Jussy");
        System.out.println(jussy);

        //如果是静态方法，则直接show.invoke(Person.class)


    }
}
