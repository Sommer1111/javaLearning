package day4_22_lambdaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Auther:sommer1111
 * @date 2020/4/26 16:49
 */
public class StreamAPITest {
    //使用 Stream API 对集合数据进行操作，集合讲的是数据，Stream讲的是计算
    /**
     * 1.创建 Stream
       一个数据源（如：集合、数组），获取一个流
     * 2.中间操作
       一个中间操作链，对数据源的数据进行处理
     * 3.终止操作(终端操作)
       一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
     */
    public static void main(String[] args) {

        //1.使用集合来创建
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);

        System.out.println(list);
        Stream<Integer> stream = list.stream();
        stream.sorted().forEach(System.out::println);

        //2.通过数组来创建
        Integer[] integers = new Integer[]{1,5,8,1,0};
        System.out.println(Arrays.toString(integers));
        Stream<Integer> stream1 = Arrays.stream(integers);
        stream1.distinct().forEach(System.out::println);

        //3.Stream里面的方法
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        //4.创建无限流iterate()、generate(）
        Stream.iterate(0,t->t+2).limit(5).forEach(System.out::print);

    }

     }
