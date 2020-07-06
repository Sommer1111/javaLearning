package DataStructureTest.Sort;

import java.util.Arrays;

/**
 *
 * 归并排序
 * 1.分之，递归拆分成子序列
 * 2.治之，从下面开始合并
 *
 * 分析：
 * 1. 8个数字的数组需要排序，8——4——2——1，这样分，分别是左递归分、右递归分、合并
 *    |---先是左递归，一直递归，到左边拆的只剩下 1 个数字
 *    |---然后回到 1 的右边——结束——合并成 2 ，再进入上一层 2的右递归，合并成 4
 *        依次递归最后合并为原来的长度。
 *
 * 总结：
 * 1. 这个递归的为什么直接是左递归、右递归、合并这个步骤有点难理解。
 *    这个时候可以直接看拆分到最小的时候，就是左边、右边、合并，这三步
 *
 * 2.理解时，太拘泥于参考代码，有时不理解，一直纠结它为什么要这样写。又是一个标准答案的思维。
 *   其实写法又很多，人家只是碰巧这样写了，我并没有必要一定跟他一样，只要最终都可实现，殊途同归。
 *   往往一定要跟他写的一模一样，毕竟不是我的思维，有时就是理解不了他为什么要这样写。
 *
 *
 * @Auther:sommer1111
 * @date 2020/7/6 9:50
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        System.out.println("这是原始数组："+Arrays.toString(arr));
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println("这是排序之后的数组："+Arrays.toString(arr));
    }

    //1.分之
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){//分到最后只剩下1个元素递归结束
            int mid = (left+right) /2;
            //左递归拆
            mergeSort(arr,left,mid,temp);
            //右递归拆
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }

    }

    //2.治之
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid+1;
        int t = 0;//temp当临时存储

        //1.单纯在前后两已排序的部分比较，把小的值复制在temp中
        while(i<=mid && j<=right){

            if(arr[i]>arr[j]){
                temp[t] = arr[j];
                j++;
                t++;
            }else{
                temp[t] = arr[i];
                i++;
                t++;
            }

        }

        //2.有一边已经排完了，另一边还有剩下。继续将剩下的复制到temp
       while(i<=mid){
            temp[t] = arr[i];
            i++;
            t++;
        }

        while(j<=right){
            temp[t] = arr[j];
            j++;
            t++;
        }

        //3.将temp中排好序的内容复制回原来的arr的相应位置中
        // 数字还是那几个，只是temp中已经排好序了。所以可以直接覆盖
        //temp ——> arr[left,left+temp.length]
        t = 0;
        while(left<=right){
           arr[left] = temp[t];
           t++;
           left++;
        }

    }
}
