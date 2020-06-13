package day4_16_reflecttion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Auther:sommer1111
 * @date 2020/4/16 10:51
 */
public class reflection_Test {
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        //程序————>javac.exe运行生成.class运行时类————>java.exe对运行时类进行解析
        //明白反射的意义：获取.class运行时类，并把它作为一个对象。获取它的属性、方法、构造器

        //哪个类创建了这个对象：获取该运行类作为实例的四种方法

        //1.调用运行时的类属性.class，得到Class的实例化对象

        Class  pc1 = Person.class;
        System.out.println(pc1);

        //2.getClass方法,获取该实例化对象缓存的运行时类
        Person p1 = new Person();
        Class pc2 = p1.getClass();
        System.out.println(pc2);

        //3.调用Class类的静态方法
        Class pc3 = Class.forName("cn.code.day4_16_reflecttion.Person");
        System.out.println(pc3);

        //4.使用类的加载器ClassLoder


        //使用ClassLoader实现配置文件的加载
        //1.配置文件加载方式一
        Properties p = new Properties();
        FileInputStream f = new FileInputStream("sommer/hello.properties");
        p.load(f);
        String name = p.getProperty("name");
        String age = p.getProperty("age");
        System.out.println(name+"的年纪为："+age);

        //2.ClassLoader实现配置文件的加载
        // 必须把内容放在同一个module中,不然报错NullPointerException
        ClassLoader classLoader = reflection_Test.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("hello2.properties");
        p.load(is);
        String name1 = p.getProperty("name");
        String age1 = p.getProperty("age");
        System.out.println(name1+"2号的年纪为："+age1);



    }
}
