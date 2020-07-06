package DataStructureTest;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 实现冒泡排序算法
 * 相邻的两个相互比较，如果前面的比后面的大则交换、循环遍历，直到没有为止
 * 优化：当一轮下来没有交换说明已经是有序的后面就不必再判断了
 *
 * @Auther:sommer1111
 * @date 2020/6/24 17:00
 */
public class boobleSorting {
    public static void main(String[] args) {
        boolean flag = false;
        int[] arr = {3,-2,5,0,1};
        System.out.println("排序前的顺序为："+ Arrays.toString(arr));
        for (int i = 0; i < arr.length-2; i++) {
            System.out.println(i);
            for (int j = 0; j < arr.length-1; j++) {
                int temp=0;
                if(arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j] ;
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            if(!flag){
                break;
            }else{
                flag = true;
            }
        }

        System.out.println("排序后的顺序为："+Arrays.toString(arr));
    }
}
