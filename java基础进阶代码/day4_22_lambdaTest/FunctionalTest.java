package cn.code.day4_22_lambdaTest;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Auther:sommer1111
 * @date 2020/4/25 9:22
 */


// 其实lambda就是一个对象,有函数式接口就可以接受Lambda表达式作为函数式接口的实现
// java是面向对象的，但是为了写起来方便，
// 需要向一个方法传递一个方法，但是实际上并不能传递方法
// 而是传递了只有一个抽象方法的接口的实现类的对象
// 这样就做到类似传递方法了，

public class FunctionalTest {
    public static void main(String[] args) {
        //函数式接口的测试:Consumer<T>,
        //也就是，Lambda的左边以及相当于这一串
        // integer = new Consumer<Integer>() {@Override public void accept(Integer integer) {}
        //右边可以理解为函数式方法的具体规则,这个才是我们具体要写的。
        //在方法的定义里面，我们则默认规则已经指定————>这就是"函数式"的贴切性！
        /**
         * accept():System.out.println("消费掉："+integer);
         * get():s
         * apply():integer*100
         * test():contains("里")
         */


        //1.Consumer只负责接收数据，没有返回值。
        my1test(100, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("消费掉："+integer);
            }
        });
        System.out.println("-------------------------------");
        //lambda表达式的测试
        my1test(90,integer -> System.out.println("消费掉"+integer));

        //2.Supplier测试,这里比较难理解，空参调用它，获取你想要获取得东西(对象、属性)。

        String s = "Here";
        System.out.println(my2test(()->s));

        //比如通过Supplire函数式接口来生成Student对象并去拿属性
        //my2test(()->new Student)
        //System.out.println(sup.get().getName())

        //3.Function,相当于实现某种功能，apply应用到你的输入里面，如函数一样，输入->输出
        // Function<Integer, Integer>,代表输入为整数，返回得结果也是整数
        //如果想把接受一些输入参数并将对输入参数处理过后的结果返回的功能封装到一个方法内，
        // Function接口是一个不错的选择。
        System.out.println(my3test(12,integer -> integer*100));

        //4.Predicate,判断
        String[] s4 = {"这里","那里","哪里","这些"};
        ArrayList<String> list = my4test(s4, ts -> ts.contains("里"));
        System.out.println(list);

    }

    //1.Consumer
    public static void my1test(Integer i ,Consumer<Integer> con){
        con.accept(i);
    }

    //2.Supplier
    public static String my2test(Supplier<String> sup){
        return sup.get();
    }

    //3.Function
    public static Integer my3test(Integer i,Function<Integer,Integer> fun){
        Integer apply = fun.apply(i);
        return apply;
    }

    //4.Predicate
    public static ArrayList<String> my4test(String[] s, Predicate<String> pre){
        ArrayList<String> strings = new ArrayList<>();
        for(String s4:s){
                boolean test = pre.test(s4);
                if(test){
                    strings.add(s4);
                }
        }
        return strings;
    }




}