/**
 * 要求：
 *    给你两个二进制字符串，返回它们的和（用二进制表示）。
 *    输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  思路一：二进制字符串——>转化成十进制数，求和——>和转化成二进制形式
 *
 *   问题：数大了超范围溢出,在 Java 中：
     * 如果字符串超过 3333 位，不能转化为 Integer
     * 如果字符串超过 6565 位，不能转化为 Long
     * 如果字符串超过 500000001500000001 位，不能转化为 BigInteger
     * 因此，为了适用于长度较大的字符串计算，我们应该使用更加健壮的算法。
 *
 *
 *  思路二：按位相加，逢二进一。短的数前面补零。每一位相加还要加上后一位的进位。
 *
 *  总结：
 *  1.判断谁大谁小的精炼表达：
 *   int n = Math.max(a.length(), b.length())
 *  2.将判断范围的各种情况赋值写成一句话的精炼表达
 *   carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
 *  3.我在考虑进位时，拘泥于进位的传递，它这里把每一位都独立出来思考。
 *  以及按位取如何取对应的循环该如何实现，这里借用了中间变量。可以共同使用。
 *
 * @Auther:sommer1111
 * @date 2020/6/23 14:07
 */
public class _06_BinarySum {
    public static void main(String[] args) {
        System.out.println(addBinary("1101","1"));
        System.out.println(addBinary3("1101","1"));
    }

    public static String addBinary(String a, String b) {
        int a1 = Integer.valueOf(a,2);
        int a2 = Integer.valueOf(b,2);
        String sum = Integer.toBinaryString(a1 + a2);
        return sum;
        //优化：
        // return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));

    }

    public String addBinary2(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;//初始进位设置为0
        for (int i = 0; i < n; ++i) {
            //对应位置相加，每一位的答案为 （carry+a+b)%2，如果此时索引已经大于长了，补零。
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            //进位计算=（carry+a+b)/2
            carry /= 2;
        }
        //如果最后一一次的进位为1，那么就要总体要进一位
        if (carry > 0) {
            ans.append('1');
        }
        return ans.reverse().toString();
    }

    public static String addBinary3(String a,String b){
        StringBuffer res = new StringBuffer();
        int n = Math.max(a.length(),b.length());
        int carry = 0;

        for (int i = 0; i < n; i++) {
           carry += i< a.length() ? (a.charAt(a.length()-1-i)-'0'):0;
           carry += i< b.length() ? (b.charAt(b.length()-1-i)-'0'):0;

           res.append( (carry %2));//是否转换成char没有什么影响
           carry = carry/2;
        }
        if(carry>0){
            res.append(1);
        }

        return res.reverse().toString();
    }

}
