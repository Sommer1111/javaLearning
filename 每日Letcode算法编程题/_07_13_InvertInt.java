/**
 * 题目：
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 数值范围为 [−2^31,  2^31 − 1]。如果反转后整数溢出那么就返回 0。
 * 分析：
 *  ① 负数
 *  ② 末尾是 0 的数
 *
 *  思路一、转字符串————>又是笨方法低效。。。。。难过
 *  1.判断范围
 *  2.转换成字符串分情况处理
 *
 *  思路二：类似于栈（但是如果直接是栈的话不好判断溢出），模取最末尾数，另外再判断是否溢出
 *  ①从 ans*10+pop > max 这个溢出条件来看
 *    |---当出现 ans> max/10且还有 pop需要添加时，则一定溢出
 *    |---当出现 ans= max/10且 pop>7时，则一定溢出，7是2^31-1的个位数
 *  ②从 ans*10+popく min 这个溢出条件来看
 *    |---当出现ans< min/10且还有 pop需要添加时，则一定溢出(注意负数的小 -22 < -21)
 *    |---当出现ans= min/10且 popく-8 时，则一定溢出，8是-2^31的个位数
 *
 * @Auther:sommer1111
 * @date 2020/7/13 20:11
 */
public class _07_13_InvertInt {
    public static void main(String[] args) {
        System.out.println(reverse2(123));
        System.out.println(reverse2(-163));
        System.out.println(reverse2(1230));
        System.out.println(reverse2(-9980));
    }

    public static int reverse(int x) {
        int min = (int) -Math.pow(2,31);
        int max = (int) Math.pow(2,31) -1;
        if(x<min || x>max ){
            return 0;//这里忽略了一点就是，反转之后的数也可能超范围
        }else{
            String s = Integer.toString(x);
            if(s.length()==0){
                return x;
            }
            if(s.charAt(s.length()-1) =='0'){
                s = s.substring(0,s.length()-1);
            }

            if(s.charAt(0) =='-'){
                s = s.substring(1);
                return -Integer.parseInt(new StringBuffer(s).reverse().toString());
            }

            return Integer.parseInt(new StringBuffer(s).reverse().toString());
        }

    }

    public static int reverse2(int x){
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int res = 0;
        while(x != 0){
            int temp = x%10;//取个位、十位、百位数。。。。
            if((res>max/10 ||(res==max/10 &&temp>7)) ||(res<min/10 ||(res==min/10 &&temp<-8))){
                return 0;
            }
            res = res*10 + temp;//依次拼接到新数中去
            x /= 10;

        }
        return res;
    }
}
