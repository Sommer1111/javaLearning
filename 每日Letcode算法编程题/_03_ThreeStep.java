package Algorithm_ex;

/**
 *问题描述：三步问题。
 *     有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 *     实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 【思路分析】：
 * 分析：类似于斐波那契数列，用递归，f(n) = f(n-1)+f(n-2)+f(n-3)
 *     1.在第n个台阶：有3种方法到达
 *        1.1：n-1 走一步
 *        1.2：n-2 走两步
 *        1.3：n-3 走三步（1、1+2、3）
 *     2.
 *     f(1)=1，f(2)=2，f(3)=4
 *     f(4) = 1+2+4=7
 *     f(5) = 2+4+7= 13
 *
 * 递归费时的原因：
     *  1.递归的实现是通过调用函数本身，函数调用的时候，每次调用时要做地址保存，参数传递等，
     *  这是通过一个递归工作栈实现的。具体是每次调用函数本身要保存的内容包括：局部变量、形参、
     *  调用函数地址、返回值。那么，如果递归调用N次，就要分配N局部变量、N形参,
     *  N调用函数地址、N返回值，这势必是影响效率的
 *      2.同时，这也是内存溢出的原因，因为积累了大量的中间变量无法释放。
 *     相对来讲循环迭代则不需要
 *
 * 取模的讲究：
 *       假如对三个dp[i-n]都 % 1000000007，那么也是会出现越界情况（导致溢出变为负数的问题）
 *       因为如果本来三个dp[i-n]都接近 1000000007 那么取模后仍然不变，但三个相加则溢出
 *       但对两个较大的dp[i-n]:dp[i-2],dp[i-3]之和 mod 1000000007，那么这两个较大的数相加大于 1000000007但又不溢出
 *       取模后变成一个很小的数，与dp[i-1]相加也不溢出
 *
 *
 *
 * @Auther:sommer1111
 * @date 2020/6/3 9:08
 */
public class _03_ThreeStep {
    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        System.out.println(step1(40));
        long l2 = System.currentTimeMillis();
        System.out.println("此次计算费时："+(l2-l1));

        long l3 = System.currentTimeMillis();
        System.out.println(step1(40));
        long l4 = System.currentTimeMillis();
        System.out.println("此次计算费时："+(l4-l3));

        long l5 = System.currentTimeMillis();
        System.out.println(step1(40));
        long l6 = System.currentTimeMillis();
        System.out.println("此次计算费时："+(l6-l5));
    }


    //方法一：自己的思路递归，发现时间超出限制
    public static int step1(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 4;
        }
        return ((step1(n-1)+step1(n-2))%1000000007+step1(n-3))%1000000007;
    }

    //参考优化用循环迭代
    public static int step2(int n){
        if(n<=2){
            return n;
        }
        int a=1,b=2,c=4;
        for (int i = 3; i <n ; i++) {
            int temp = ((a+b) % 1000000007 + c) % 1000000007;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }

    //参考优化2
    public static int step3(int n){
        int[] stepNumber = new int[n];
        stepNumber[0]=1;
        stepNumber[1]=2;
        stepNumber[2]=4;

        for(int i=3;i<n;i++){
            //直接将每一次迭代的内容存起来了，避免拿着资源造成低效费时
            stepNumber[i] =((stepNumber[i-1]+stepNumber[i-2])%1000000007 +stepNumber[i-3])%1000000007;
        }
        return stepNumber[n-1];
    }
}
