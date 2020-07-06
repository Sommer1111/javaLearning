/**
 * 要求：
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 *
 * 我的思路：缺二分法的思维
 *   |---首先枚举 a，并保证 c - a^2 >= 0
 *   |---随后我们通过二分查找的方法找出是否存在 b，满足 b^2 = c - a^2。
 *   |---二分查找的范围为 [0, c - a^2]
 *
 * 学习二分法：
 *   |--- 找到左端点、右端点，找中点：mid = left+(right-left)/2
 *   |--- 判断中点大了还是小了。
 *      |---如果大了，则缩小范围为[left,mid-1]
 *      |---如果小了，则扩大范围为[mid+1,right]
 *
 *
 * @Auther:sommer1111
 * @date 2020/7/1 21:22
 */
public class _07_01_judgeSquareSum {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum2(25));

    }
    public static  boolean judgeSquareSum(int c) {
        for (int a = 0; a <=Math.sqrt(c); a++) {
            double b = Math.sqrt(c-a*a);
            if(b == (int) b){
                return true;
            }
        }
        return false;
    }

    public static boolean judgeSquareSum2(int c){
        for (int a = 0; a *a<c ; a++) {
            int b = c- a*a;
            if(find_binary(0,b,b)){
                return true;
            }
        }
        return false;
    }

    public static boolean find_binary(int left,int right,int findnum){

        if(left>right){
            return false;
        }
        int mid = left +(right-left)/2;
        if(mid *mid==findnum){
            return true;
        }else if(mid*mid>findnum){
            return find_binary(left,mid-1,findnum);
        }else{
            return find_binary(mid+1,right,findnum);
        }

    }
}
