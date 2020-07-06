/**
 * 要求：统计所有小于非负整数 n 的质数的数量。
 * 思路：
 * 1.循环自增遍历
 * 2.问题：如何判断素数。能整除2，3，5，7的就不是
 *
 *
 * 学习：
 * 1.题解是要考虑时间复杂度和空间复杂度的，不是单纯的解出来就可以了。
 * 2.优化，提升性能的地方。
 *      ① 遍历到根号n，不用遍历到n，两部分是对称的。
 *      ② 筛法
 * 3.为什么别人要用数组？因为通过数组标记，if（）判断一结合直接就减少了判断的次数 “埃拉托斯特尼筛法”
 *
 * @Auther:sommer1111
 * @date 2020/6/15 15:11
 */
public class _07_PrimesJudge {

    public static void main(String[] args) {
        System.out.println(judge(100000));
        System.out.println(countPrimes1(100000));
        System.out.println(countPrimes2(100000));
    }

    //不知道为何，当测试用例1000000很大时就出问题了。
    //逻辑出了问题，我这样无法判断质数与质数的倍数
    //时间复杂度：O(n)，暴力求解
    public static int judge(int n){
        int count =0;
        //可以增加一个判断n是否符合范围
        for (int i = 1; i <n; i++) {

            if(i <= 10){
                if(i==2||i==3||i==5||i==7){
                    count++;
                }
            }else if(!(i%2==0 || i%3 ==0 || i%5==0 || i%7 ==0)){
                count++;
            }
        }
        return count;
    }

    //参考
    public static int countPrimes1(int n) {
        int result = 0;
        boolean[] b = new boolean[n];   // 初始化默认值都为 false，为质数标记
        if(2 < n) result++; // 如果大于 2 则一定拥有 2 这个质数

        for(int i = 3; i < n; i += 2){  // 从 3 开始遍历，且只遍历奇数，2的倍数筛出
            if(!b[i]){  // 是质数
                //分析：
                //3初始是false，然后进入循环，把3*3=9、3*5=15、3*7=21.....都标记完了晒出了一部分
                //5的倍数
                //7的倍数
                for(int j = 3; i * j < n; j += 2){
                    b[i * j] = true;    // 将当前质数的奇数倍都设置成非质数标记 true
                }
                result++;   // 质数个数 +1
            }
        }
        return result;
    }

    public static int countPrimes2(int n) {
        boolean[] isPrim = new boolean[n];

        for (int i = 2; i * i < n; i++) {//只要遍历到根号n就可以了
            if (!isPrim[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrim[i]) count++;
        }
        return count;
    }

}
