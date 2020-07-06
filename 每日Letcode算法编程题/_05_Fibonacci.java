package Algorithm_ex;

/**
 * 总结：
 * 1.数比较大时用递归总是耗时：
 *   优化方法：
 *          * 赋值给数组保存中间变量，缺点：容易数组越界，情况需要分情。
 *          * 利用中间变量，直接释放资源。
 * 2.求余比较耗时，可以采用减去1000000007
 *
 * @Auther:sommer1111
 * @date 2020/6/9 8:31
 */
public class _05_Fibonacci {
    public static int fib(int n) {
        //用迭代完成总是超时
        if(n<2){
            return n;
        }else{
            return (fib(n-1)+fib(n-2)) % 1000000007;
        }
    }

    //优化1：用数组把每一次的结果存储起来,遇到的问题试试容易数组越界。需要格外分类
    public static int fib2(int n){
        if(n<2){
            return n;
        }else{
            int[] fib = new int[n+1];
            fib[0] =0;
            fib[1] = 1;
            for (int i = 2; i <n+1; i++) {
                fib[i] = (fib[i-1]+fib[i-2]) % 1000000007;
            }
            return fib[n];
        }

    }

    //优化2：借助中间变量 temp
    public static int  fib3(int n){
        if(n<2){
            return n;
        }else{
            int b = 1,c = 1;
            for (int i = 2; i <n; i++) {
                int temp = (b+c) % 1000000007;
                b = c;
                c = temp;
            }
            return c;
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(fib3(i));
        }
    }
}
