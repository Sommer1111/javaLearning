package DataStructureTest.Search;

import java.util.ArrayList;

/**
 * 插值查找算法
 * 分析：
 *  针对二分查找算法对于首末位置查找的低效算法的优化
 *  其本质也就只是改变了 mid=left + (right – left) /2 的计算方法，可以动态规划 mid
 *     mid = left + (right – left) * (find – arr[left]) / (arr[right] – arr[left])
 *     观察(find – arr[left]) / (arr[right] – arr[left])反映了所找数字在总体中的的位置（比例）
 * 总结：
 *  1）对于数据量较大，关键字分布比较均匀的查找表来说，采用插值查找, 速度较快.
 *  2) 关键字分布不均匀的情况下，该方法不一定比折半查找要好
 *
 * @Auther:sommer1111
 * @date 2020/7/12 14:54
 */
public class InsertSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,6,8};
        ArrayList<Integer> list = InsertSearch(arr, 0, arr.length - 1, 6);
        System.out.println(list);

    }

    public static ArrayList<Integer> InsertSearch(int[] arr, int left, int right, int find){
        int mid = left + (right - left) * (find - arr[left]) / (arr[right] - arr[left]);
        ArrayList<Integer> list = new ArrayList<>();//用list装多个出现的

        if(left>right || find < arr[left] || find> arr[right]){//避免数组越界
            return list;
        }

        if(arr[mid] ==find){
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
            return InsertSearch(arr,left,mid-1,find);
        }

        while(find > arr[mid]){
            return InsertSearch(arr,mid+1,right,find);
        }
        return list;
    }
}
