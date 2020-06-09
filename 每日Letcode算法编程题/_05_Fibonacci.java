package Algorithm_ex;

/**
 * �ܽ᣺
 * 1.���Ƚϴ�ʱ�õݹ����Ǻ�ʱ��
 *   �Ż�������
 *          * ��ֵ�����鱣���м������ȱ�㣺��������Խ�磬�����Ҫ���顣
 *          * �����м������ֱ���ͷ���Դ��
 * 2.����ȽϺ�ʱ�����Բ��ü�ȥ1000000007
 *
 * @Auther:sommer1111
 * @date 2020/6/9 8:31
 */
public class _05_Fibonacci {
    public static int fib(int n) {
        //�õ���������ǳ�ʱ
        if(n<2){
            return n;
        }else{
            return (fib(n-1)+fib(n-2)) % 1000000007;
        }
    }

    //�Ż�1���������ÿһ�εĽ���洢����,����������������������Խ�硣��Ҫ�������
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

    //�Ż�2�������м���� temp
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
