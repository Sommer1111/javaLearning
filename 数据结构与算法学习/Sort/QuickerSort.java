package DataStructureTest;

import java.util.Arrays;

/**
 * 实现快速排序
 * 思路：
 *     |---指定一个中介值，左边放比它小的数右边放比它大的数。不断循环交换。
 *        |---当出现 l>r 的情况的时候，说明中介值左边全是小的，右边全是大的。每一次的
 *            循环都会在当前这个数组范围是实现这种排序。
 *        |---此时的 r在中介值前一个位置。这时开始左边的小值递归，达到缩小范围。
 *
 *     |---左端递归 [left,r]，改变中介值，再换。换完再左端递归
 *        |---缩小到交换最左边的两个元素时，交换之后不再满足 left<r ,完成左端递归
 *        |--开始右边循环。
 *
 *     |--右端递归 [l,right],同理
 *
 *   总结：
 *     发现算法的关键节点，没有那么容易理解，最快的方法是自己推算一下。就清晰了
 *
 * @Auther:sommer1111
 * @date 2020/7/5 16:04
 */
public class QuickerSort {

    public static void main(String[] args) {
        int[] arr = {-21,5,-1,0,77,-2,0};
        System.out.println("这是初始数组："+Arrays.toString(arr));
        quickerSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickerSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        //设置中介值
        int pivot = arr[(left+right) / 2];
        int temp = 0;
        while(l<r){
             while(arr[l]<pivot){
                 l+=1;
             }

             while(arr[r]>pivot){
                 r-=1;
             }

             if(l>=r){//自己推算，会发现出现这种情况表示中介值左边全是小、右边全是大。
                 break;
             }

             //跳出了上面的循环，说明两边都找到符合条件的值。交换

             temp = arr[r];
             arr[r] = arr[l];
             arr[l] = temp;

             //这两句的作用是如果碰到了相同的数时移动，不然就无限循环了
             if(arr[r] == pivot){
                 l+=1;
             }

             if(arr[l] == pivot){
                 r-=1;
             }
        }



        //上面的循环是在 l==r 的时候跳出的循环，所以，这里需要这一步。
        if(l==r){
            l+=1;
            r-=1;
        }

        if(left<r){
            //System.out.println("左边迭代开始！");
            quickerSort(arr,left,r);
            //System.out.println("这是最终左循环出来的："+Arrays.toString(arr));
        }

        if(right>l){
            //System.out.println("左边迭代开始！");
            quickerSort(arr,l,right);
            //System.out.println("这是最终右循环出来的："+Arrays.toString(arr));
        }


    }
}


