/**
 * 题目：
 *   实现 int sqrt(int x) 函数。计算并返回 x 的平方根，其中 x 是非负整数。
 *   由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去
 *
 * 分析：
 *     法一：二分法，找到一个值的平方小于次数，后一个值的平方大于此数
 *         |--时间复杂度：O(log x)，即为二分查找需要的次数。
 *         |--空间复杂度：O(1)。
 *     法二：
 *        数学法，将幂转换成指数直接计算,时间复杂度 O(1)
 *
 * 总结：int 相乘溢出，通过前面加一个 (long) mid*mid 来处理
 *     int范围   -2147483648 ~ 2147483647
 *    System.out.println(100000000*1000 );输出结果是：1215752192
 *       |---计算结果转化为二进制：10111 01001000 01110110 11101000 00000000
 *       |---由于int类型表示的最大值是32位即：01001000 01110110 11101000 00000000，
 *           前面的10111属于溢出部分，自动去除
 *       |---将01001000 01110110 11101000 00000000再转化为十进制即可得：1215752192
 *
 *
 * @Auther:sommer1111
 * @date 2020/8/8 15:48
 */
public class _08_08_sqrt {

    public static void main(String[] args) {

        System.out.println(mySqrt(2147395599));

        System.out.println(mySqrt(8));
        System.out.println(mySqrt(16));
        System.out.println(mySqrt(1));


    }

    public  static int mySqrt(int x) {
        if(x==0 || x==1){
            return x;
        }

        int left = 0;
        int right = x;
        int mid =0;
        while(left<=right){
            mid =( right-left )/2+left;
            if(mid*mid==x){
                return mid;
            }
            if((long)mid*mid <= x){//当输入过大时整数出现溢出，判断失误
                left = mid+1;
            }else{
                right = mid-1;
                mid-=1;
            }
        }

        return mid;

    }

    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int)Math.exp(0.5 * Math.log(x));
        return (long)(ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}
