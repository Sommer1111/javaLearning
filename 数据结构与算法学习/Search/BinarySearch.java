package DataStructureTest.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找；针对有序序列的查找
 * 1. 折半：mid = (left+right)/2
 * 2. 分析
 *   |---对于起始末尾的数查找效率不高
 *   |---查找不存在的数会无限递归：
 *      ①如下找 7，一直递归到 mid = 5，right = 6，此时 ——> binarySearch(arr,6,6,7)
 *      ②得到新的 mid = 6, 7< arr[6] = 8,进入左边——> binarySearch(arr,6,5,7),如此递归循环出不来。
 *   |---如果该数出现多次，只能找到第一次出现的下标。
 *
 *
 *
 * @Auther:sommer1111
 * @date 2020/7/12 14:16
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,6,8};
        //int i = binarySearch(arr, 0, arr.length - 1, 6);
        ArrayList<Integer> list = binarySearch2(arr, 0, arr.length - 1, 0);
        System.out.println(list);

    }

    public static int binarySearch(int[] arr,int left,int right,int find){
        int mid = (left+right)/2;
        if(arr[mid] ==find){
            return mid;
        }
        while(find < arr[mid]){
            return binarySearch(arr,left,mid-1,find);
        }

        while(find > arr[mid]){
            return binarySearch(arr,mid+1,right,find);
        }
        return -1;
    }

    //优化升级版
    public static ArrayList<Integer> binarySearch2(int[] arr,int left,int right,int find){
        int mid = (left+right)/2;
        ArrayList<Integer> list = new ArrayList<>();//用list装多个出现的

        if(left>right){//优化一：找不到的出现的无限递归。此时有一个特征，就是 left > right
            return list;
        }

        if(arr[mid] ==find){//优化二：出现多个的情况。
            //如果找到了一个，因为是有序数组，所以再看看前后是否也有
            int temp = mid;
            while(arr[temp-1] == find){//找左边
                list.add(temp-1);
                temp--;
            }
            list.add(mid);//自己也不能忘记加进去
            while(arr[temp+1] ==find){//找右边
                list.add(temp+1);
                temp++;
            }

        }
        while(find < arr[mid]){
            return binarySearch2(arr,left,mid-1,find);
        }

        while(find > arr[mid]){
            return binarySearch2(arr,mid+1,right,find);
        }
        return list;
    }
}
