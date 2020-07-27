package DataStructureTest.Sort;

import java.util.Arrays;

/**
 * 说明：堆排序，基于完全二叉树的一种排序方法。
 *  1. 大顶堆：每一个父节点的值都大于子节点。（相当于跳着找到了数据里面的最大值）
 *  2. 将大顶堆根节点的值与末尾最后一个值交换。（把最大的值放到了最末尾）
 *  3. 循环，得到最后排序的数组。时间复杂度:O(nlog(n))
 *
 *  实现：
 *  1.得到大顶堆
 *    |--- 找到第一个非叶子节点，k = lenth/2 -1
 *    |---比较此节点与子节点的大小关系，把三者中最大的值换到此位置。k-1继续
 *    |---上层值得交换，又会影响下层值的大小，所以不能换完就直接退出，
 *        还要递归往下再交换（这步较难理解，见代码细细解释）
 *        所以递归往下，也需要一个终止条件：k不能大于length
 *
 *
 * @Auther:sommer1111
 * @date 2020/7/27 16:36
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {2,4,6,1,0,-21,99,28,7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));


    }

    //1.实现传入数组，得到大顶堆,arr为传入待排序的数组，i为第一个非叶子节点的位置。
    public static void BigHeap(int[] arr,int i ,int length){
        int temp = arr[i];//把值先存起来
        //循环每一个非叶子节点与其子节点的比较交换,因为 i 在变，所以j的初始值不变

        for (int j = 2 *i+1; j <length; j =2 *j+1 ) {
            //判断那个子节点更大。定位到更大的子节点
            if(j+1<length && arr[j]<arr[j+1]){//防止数组越界
                j++;
            }
            //循环找位置,注意这里拿来比较的是temp
            if(temp<arr[j]){
                arr[i] = arr[j];
                i = j;//此时就是要保证下面的如果变了会继续交换，直到找到位置
            }else{
                break;
            }

        }
        //交换值，此时的i如果要往下继续交换的话，就已经不是原来的父节点了，其实是arr[k]
        arr[i] = temp;

    }
    //2.传入大顶堆得到排序数组的最终堆排序
    public static void heapSort(int[] arr){
        int temp = 0;
        for (int i = arr.length/2-1; i >= 0; i--) {
            BigHeap(arr,i,arr.length);
        }

        for (int i = arr.length-1; i>0 ; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            BigHeap(arr,0,i);
        }

    }
}
