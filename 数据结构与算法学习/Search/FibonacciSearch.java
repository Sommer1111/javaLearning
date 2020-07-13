package DataStructureTest.Search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 斐波那契查值法：
 * 1. 针对插值查找法对于分布不均匀的数据不太理想，提出新的 mid 计算方法。
 * 2. 基于斐波那契数列几近于黄金分割的这种自然特性，mid= low + F(k-1)-1
 *    |---斐波那契数列：{1，1，2，3，5，8，13 ...}，及 F(k) = F(k-1)+F(k-2)
 *    |---将数据按斐波那契数列的对应位置分割，如长度为8.就分成 3+5，其中 mid = 2（第三个数据）
 *
 * 分析：
 * ① 如果数据的长度不符合斐波那契数列的个数，则需要补齐（在后面补最后一个数）
 *   如：{1,8, 10, 89, 1000, 1234} ——> {1,8, 10, 89, 1000, 1234，1234，1234}
 * ② 再将符合要求的数列查找
 *
 * 总结：
 * 在 mid 更新的这一步搞不好，写不出来，老是堆栈溢出。
 * 上来便写多个值要查询的这种，错误百出，问题很多。所以还是老老实实从简单做人。
 *
 * @Auther:sommer1111
 * @date 2020/7/12 14:53
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int[] f ={1,8, 10, 89, 1000, 1234};
        int index = FibonacciSearch(f, 1234);
        System.out.println("index="+index);

    }

    public static int FibonacciSearch(int[] arr, int find) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        int[] f = fibonacci();

        //改变数组符合斐波那契的要求
        int k = 0;
        while (f[k] < arr.length) {//找到最适合斐波那契 arr的个数
            k++;
        }
        //变数组的长度为fib[k]
        int[] arrnew = Arrays.copyOf(arr, f[k]);//直接复制，后面增加的长度会补 0
        for (int i = arr.length - 1; i < f[k]; i++) {
            arrnew[i] = arrnew[arr.length - 1];
        }

        //用斐波那契法查找，我这一段写的很艰难。k没有更新，所以一直出现栈溢出这个错误。
        //F[k] = F[k-1]+F[k-2],将数组分成了前面 F[k-1]个的+后面 F[k-2]个

        //如果中间值比要找的数小，那么在后一段，所以继续拆分 F[k-2] = F[k-3]+F[k-4]
        //从F[k-1] ——> F[k-3],所以 k-2

        //如果中间值比要找的数大，那么在前一段，所以继续拆分 F[k-1] = F[k-2]+F[k-3]
        //从F[k-1] ——> F[k-2],所以 k-1
        while (left <= right) {//避免递归死循环
            mid = left + f[k - 1] - 1;
            if (arrnew[mid] < find) {
                left = mid + 1;
                k -= 2;
            } else if (arrnew[mid] > find) {
                right = mid - 1;
                k++;
            } else {
                if (mid <= right) {
                    return mid;
                } else {
                    return right;//因为可能长度不够，给它补上了，所以不能把补上的也返回
                }
            }
        }
        return -1;
    }



    //生成斐波那契数列
    public static int[] fibonacci(){
        int[] f = new int[20];
        f[0] = 1;//数列的初始值
        f[1] = 1;
        for (int k = 2; k <20; k++) {
            f[k] = f[k-1]+f[k-2];
        }
        return f;
    }
}
