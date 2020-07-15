/**
 * 题目描述:
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 如：121 true
 *    -121 false
 *
 * 分析：
 * 1.负数都不是
 * 2.正个位数都是
 * 3.其余的将其反转前后是否相等
 * 法一：全部反转
 * 法二：反转一半，而这半（由整个过程我们不断将原始数字除以 10，然后给反转后的数字乘上 10，
 * 当原始数字小于（奇数）或等于（偶数）反转后的数字时，就意味着我们已经处理了一半位数的数字了）
 *
 * @Auther:sommer1111
 * @date 2020/7/14 19:47
 */
public class _07_14_isPalindrome {
    public static void main(String[] args) {
        //System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(1234321));
        //System.out.println(isPalindrome(10));

    }

    public static boolean isPalindrome(int x){
        Integer rea = x;
        if(x<0){
            return false;
        } else {
           Integer res = 0;
            while (x != 0) {
                int temp = x % 10;
                res = res * 10 + temp;
                x /= 10;
            }
            //当数据范围超[-128,127]时不等
            //return Integer.toString(res).equals(Integer.toString(x));
            return res.equals(rea);

        }
    }

    //优化，既然是回文，只需要判断一半。
    public boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
