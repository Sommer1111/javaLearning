package Algorithm_ex;

import java.util.ArrayList;
import java.util.List;

/**
 *【问题描述】：
     * 给你一个数组 candies 和一个整数 extraCandies ，
     * 其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
     * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，
     * 此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
 *
 * 【思路分析】：
 * 1.遍历取出每一个小孩的糖果数；
 *    思路一：变化之后遍历对比每一个元素，return
 *         1.1）如果数组很大，遍历对比每一个低效
 *    思路二：先找出除变化的这个数之外，此数组的最大值
 *         2.1）遍历除这个数很麻烦
 *    思路三：找到数组最大值，return 本值+差值>max
 *
 * 【总结】：
 *    1.Math.max(a,b),可以灵活运用
 *    2.length:数组的属性，直接调用，candies.length
 *      length():字符串的方法，返回int 型的长度
 *      size():List集合的方法，与字符串的length()相对应。
 *
 * @Auther:sommer1111
 * @date 2020/6/1 9:55
 */
public class _02_childcandies {
    public static void main(String[] args) {
        int[] candies={8,2,7,0,5,3,4,5};
        int extraCandies = 3;
        List<Boolean> booleans = kidsWithCandies(candies, extraCandies);
        System.out.print("[ ");
        for(int i = 0;i<booleans.size();i++){
            System.out.print(booleans.get(i)+" ");
        }
        System.out.println("]");


    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int len = candies.length;
        int max=0;
        //遍历找到最大值
        for(int i:candies){
            //优化：max = Math.max(max, candies[i]);
            if(i > max){
                max = i;
            }
        }
        //对比每一个
        List<Boolean> newcan = new ArrayList<>();
        for(int i =0;i<candies.length;i++){
            //优化：newcan.add(candies[i] + extraCandies >= max);
            if(candies[i]+extraCandies >= max){
                newcan.add(true);
            }else{
                newcan.add(false);
            }
        }
        return newcan;


    }
}
