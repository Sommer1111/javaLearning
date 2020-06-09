package cn.code.day4_22_lambdaTest;

import cn.code.day4_16_reflecttion.Person;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Auther:sommer1111
 * @date 2020/4/26 9:23
 */
public class MethodTest {
    //方法引用即有相同的参数和返回，一样的作用既可以替换使用
    public static void main(String[] args) {

        //1.对象：：实例方法,常用：Consumer的System.out。println相当于println
        // 方法引用可以自行推断，所以不需要加入参数
        Consumer<String> con1 = str-> System.out.println(str+",我是打印小帮手");
        con1.accept("小米");
        //换成方法引用:对象out的实例方法println
        PrintStream out = System.out;
        Consumer<String> con2 = out::println;//
        con2.accept("子曰");

        //Supplier的get与geName()类似
        Person p = new Person(13,"小明","China");
        Supplier<String> sup = () ->p.getName();
        System.out.println(sup.get());
        //引用:=对象p的实例方法getName()
        Supplier<String> p1 = p::getName;
        System.out.println(p1.get());


        // 2.类 :: 静态方法
        //Comparator中的int compare(T t1,T t2)
        //Integer中的int compare(T t1,T t2)
        Comparator<Integer> com1 = (t1,t2)->Integer.compare(t1,t2);
        System.out.println(com1.compare(12,32));
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(12,12));

        //3.类::实例方法
        // Comparator中的int comapre(T t1,T t2)
        // String中的int t1.compareTo(t2)
        Comparator<String> com3= (s1,s2)->s1.compareTo(s2);
        System.out.println(com3.compare("12","32"));
        Comparator<String> com4 = String::compareTo;
        System.out.println(com4.compare("qwe","asd"));

        //二、构造器引用
        Supplier<Person> s = ()->new Person();
        System.out.println(s.get().getName());
        Supplier<Person> s1 = Person::new;
        System.out.println(s1.get().age);

        //三、数组引用
        Function<Integer,Integer[]> f =(n)->new Integer[n];
        Integer[] integers = f.apply(13);
        System.out.println(Arrays.toString(integers));
        Function<Integer,String[]> f2 = String[]::new;
        String[] strings = f2.apply(16);
        System.out.println(Arrays.toString(strings));

    }
}
