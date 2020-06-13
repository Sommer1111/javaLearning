package day3_26_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {

    //从键盘中输入10个数存储在list中，并按倒序、从大到小的顺序显示出来
    //利用for循环实现十次输入
    //Collections的sort方法实现排序

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List list = new ArrayList();
        for (int i = 0; i <10; i++) {
            System.out.println("请输入要排序的整数:");
            list.add(scanner.nextInt());
        }
        System.out.println("输入的初始数据为"+list);

        Collections.sort(list);
        System.out.println("输入的初始数据从小到大排列为"+list);
        Collections.reverse(list);
        System.out.println("输入的初始数据从大到小排列为"+list);


    }

}
