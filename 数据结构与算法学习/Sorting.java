package DataStructureTest;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * 实现：
 * 1.选择排序
 *   |---遍历一遍所有的元素，找到最小的这个位置
 *   |---交换两个位置的元素
 *   |---循环遍历，直到完成
 *
 *   分析：需要遍历所有位置，时间复杂度为 O(n)
 *
 * 2.插入排序
 *   |---将前后当成两个部分，前面部分为有序表，后面为无序表
 *   |---遍历无序表，将无序的元素一个个拿出来
 *   |---在有序表中找位置，比较当前元素与有序表最后一个位置的大小关系，小则将该位置元素后移。
 *   继续比较，再小再后移直到到尽头或者比她大即找到位置。
 *
 *   总结：如果最小的在后面，则大部分都要移，低效需要改进
 *
 * 3.希尔排序
 *   |---基于插入排序的不足进行改进。减少后移的次数和个数。
 *   |---法一：将整个数组分为 length/2 小组，步长为 length/2，进行内部选择排序。
 *      问题：比较的次数很多，数据大时还是低效（？需再看）
 *
 *   |---法二：内部进行插入排序
 *
 *
 * 具体实现过程总结：
 * 选择排序的过程：
 *  1.看起来实现非常简单，但是在找位置与交换值的时候出错，遍历不完元素，或者导致元素被改变的情况。
 *  2.如果没有比自身小的数，其实不需要交换，可以增加一个判断的优化
 *
 *  插入排序：
 *  1.对找插入位置时后移操作的实现过程感到奇怪，难以理解。也感觉自己再程序方面常常对这种技巧、思路
 *  要理解很久，一方面是没有相关的练习经验积累，一方面是缺乏相关的思维训练。开始总是艰难的。
 *
 *  希尔排序；
 *  算法从简单到难开始写，先考虑一般情况，再把一般换成特殊，写的过程会更容易理解一些。
 *  而且自己处于菜鸟阶段，难理解非常打击自信。
 *
 * @Auther:sommer1111
 * @date 2020/6/28 10:30
 */
public class Sorting {
    public static void main(String[] args) {
        int[] arr = {32,1,8,2,5,0};
        int[] arr1 = selectSort(arr);
        int[] arr2 = insertSort(arr);
        int[] arr3 = shellSort(arr);
        int[] arr4 = shellSort2(arr);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));

        //测试大数据集下的各种排序方法的性能比较
        int[] test = new int[400000];
        for (int i = 0; i < 400000; i++) {
            test[i] = (int) Math.random()*400000;
        }
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        String str1 = s.format(date);
        System.out.println("排序前的时间是："+str1);

        //selectSort(test);//15s
        //insertSort(test);//1s
        //shellSort(test);//30s
        shellSort2(test);//1s
        //可见插入排序不必每个都要交换，移位，所以性能较高



        Date date1 = new Date();
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        String str2 = s1.format(date1);
        System.out.println("排序后的时间是："+str2);


    }

    //选择排序
    //格式化 Ctrl+Shift+L

    public static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            int min = arr[i];//初始设置第一个为最小值
            //遍历找后面的最小值
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < min) {//如果小则定位
                    min = arr[j];
                    index = j;
                }
            }

            //优化！
            if(index != i){//如果不是同一个数则交换
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
        return arr;
    }

    //插入排序
    public static int[] insertSort(int[] arr){
        //假定有序表初始只有一个元素
        int insertindex = 0;
        int insertval = 0;
        for (int i = 1; i <arr.length ; i++) {//遍历无序表
            insertval = arr[i];
            insertindex = i-1;
            //防止数组越界，判断插入位置

            //如2 3 1 5，while第二轮判断到1时，i=2
            //insertval = arr[1]=1,insertindex = 1
            //while，1<arr[1] = 3进行 赋值即insertindex后移一位，变成 2 3 3 5，1存在insertval
            //insertindex-- = 0
            //while,1<arr[0] =2,同样以赋值法后移一位，变成2 2 3 5，1存在insertval
            //insertindex-- = -1<0,循环结束，找到插入位置0

            while(insertindex >= 0 && insertval < arr[insertindex]){//遍历有序表找位置
                arr[insertindex+1] = arr[insertindex];
                insertindex--;
            }

            //优化！
            //判断位置是不是自身，如果是则不需要赋值，比如5，不需要进入循环，就是自身的位置
            //如果位置不一样，则将暂存的insertval插入，即变成 1 2 3 5
            if(insertindex+1 != i){
                arr[insertindex+1] = insertval;
            }

        }
        return arr;
    }

    //希尔排序
    public static int[] shellSort(int[] arr) {

        //当前数组假设有5个数，所以要分成2组
        //则当我有100个数是也是/2这样减少分组再判断，所以外层也需要一个循环
        for (int gap = arr.length / 2; gap >0; gap /= 2) {//每一次分组
            for (int i = gap; i < arr.length / 2; i++) {//遍历分组里面的元素
                for (int j = i - 2; j >= 0; j -= gap) {//实现每一个元素的交换
                    if (arr[j] > arr[j + gap]) {//这样拆分交换，还是非常繁琐的，所以费时
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }

                }

            }
        }
        return arr;
    }

    //希尔排序优化
    public static int[] shellSort2(int[] arr){

        for (int gap = arr.length / 2; gap >0; gap /= 2) {//每一次分组
            for (int i = gap; i < arr.length; i++) {
                //从gap开始，遍历分组里面的元素插入排序
                    int insertval = arr[i];
                    int insertindex = i;
                    if(insertval < arr[insertindex - gap]){//步长是gap
                        while(i-gap >=0 && insertval < arr[insertindex-gap]){
                            arr[insertindex] = arr[insertindex - gap];
                            insertindex -= gap;
                        }

                    }

                    arr[insertindex] = insertval;


                }


            }

        return arr;
    }



}



