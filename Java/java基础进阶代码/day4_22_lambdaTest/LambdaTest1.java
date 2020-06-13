package day4_22_lambdaTest;

import java.util.Comparator;

/**
 * @Auther:sommer1111
 * @date 2020/4/22 15:57
 */
public class LambdaTest1 {
    public static void main(String[] args) {

        //lambda的本质是作为接口的实现类，必须是一个接口
        //意义在于使代码更加紧凑，更加高效

        //->代表lambda表达式，
        // ->左边括号写参数列表，当只有一个参数时可以省略括号，
        // ->右边{}写需要实现的功能，只有一条语句时可以省略return、大括号
        Runnable r1 = new Runnable(){
            @Override
            public void run() {
                System.out.println("hello1,这是原来的实现方法");
            }
        };

        Runnable r  = () -> System.out.println("hello，这是lambda表达式的实现方法");

        r1.run();
        r.run();

        System.out.println("**********************************");

        Comparator<Integer> c1 = new Comparator<>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer.compareTo(t1);
            }

        };
        Comparator<Integer> c = (o1, o2) -> o1.compareTo(o2);
        int i = c.compare(13, 32);
        int i1 = c1.compare(12, 1);
        System.out.println(i);
        System.out.println(i1);


    }
}

