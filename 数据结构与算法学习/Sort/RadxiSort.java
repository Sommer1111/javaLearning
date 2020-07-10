package DataStructureTest.Sort;

import java.util.Arrays;

/**
 * 基数排序（桶排序的延伸）：分别按个位数、十位数、百位数排序，最终得到有序排序。
 *    |---实现：arr = [30,89,21,38,5,121,76]，排序。
 *
 * 思路分析：
 * 1.建立代表 0-9 数的桶，桶的大小应为数组的大小（用 空间 换 时间 ）
 * 2.依次对应数组，取出各数的个位
 * 3.按数大小放进桶中，放完之后再按桶的次序取出。
 *   |---个位数排序实现：[30,21,121,5,76,38,89]，思维为实现单个位数及 30、38 这类的由小到大
 *   |---十位数排序实现：[5,21,121,30,38,76,89]，思维为实现 单两位数的由小到大
 *   |---百位数排序实现：[5,21,30,38,76,89,121]。思维为实现 百位数的由小到大。
 * 4.重复循环
 *
 * 总结：
 * 1.得到数字位数的方法：(max+"").length
 * 2.在一轮循环中需要计数，从新开始之后要重新计数，但是碰到新的情况又要接下去计数的方法时
 *   另外创建一个专门存储计数的数组，就不会存在归零的苦恼。
 * 3.编程抽象从易到难：
 *   从个位数分析十位数、百位数，再从中看出规律，推及到所有情况。
 * 4.注意：我们在一开始创建数组时，就已填充了默认的数字0，此时用arr.length并得不到实际的位数！
 *
 * @Auther:sommer1111
 * @date 2020/7/8 17:23
 */
public class RadxiSort {
    public static void main(String[] args) {
        int[] arr = {30,89,21,38,5,121,76};
        radixSort2(arr);
    }

    public static void radixSort(int[] arr){

        //从个位数分析十位数、百位数，再从中看出规律，推及到所有情况
        //1.创建桶,用二维数组
        int[][] bucket = new int[10][arr.length];
        int[] bucketSize = new int[bucket.length];
        //第一次取数组元素个位数
        for(int i = 0; i < arr.length; i++) {
            int bucketNumber = arr[i] % 10;
            //一个桶一个计数器，如何在同样的桶时继续接下去？——另外创建一个数组来记录
            //这里原本使用 bucket.length 作为判断桶的大小
            // 但是bucket.length并不是里面装有的数，而直接是之前创建的10的上限值

            bucket[bucketNumber][bucketSize[bucketNumber]] = arr[i];
            bucketSize[bucketNumber]++;

        }

        //放完之后从十个桶中依次取出数据按顺序放回数组
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {//十个桶
            if(bucketSize[i] != 0){//桶中有数据
                for (int j = 0; j < bucketSize[i]; j++) {
                    arr[index++] = bucket[i][j];//桶中的数据
                }
            }

        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"  ");
        }
    }

    //抽象出的一般情况。
    public static void radixSort2(int[] arr) {


        int[][] bucket = new int[10][arr.length];
        int[] bucketSize = new int[bucket.length];
        //首先找到数组中最大的数字
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //确定循环到什么位上。
        int t = (max + " ").length();//这里开始忘记加括号，变成122了

        //多次循环，最终实现排序
        for (int k = 0, b = 1; k < t; k++, b *= 10) {
            for (int i = 0; i < arr.length; i++) {
                int bucketNumber = arr[i] / b % 10;//这里为个位十位百位的区别
                bucket[bucketNumber][bucketSize[bucketNumber]] = arr[i];
                bucketSize[bucketNumber]++;

            }

            int index = 0;
            for (int i = 0; i < bucket.length; i++) {//十个桶
                if (bucketSize[i] != 0) {//桶中有数据
                    for (int j = 0; j < bucketSize[i]; j++) {
                        arr[index++] = bucket[i][j];//桶中的数据
                    }
                    //取完之后要把计数归为0，后面十位、百位...可以继续使用
                    bucketSize[i] = 0;
                }
            }
        }

        System.out.print("最终排序结果：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
