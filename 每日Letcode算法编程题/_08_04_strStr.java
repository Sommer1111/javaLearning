/**
 * 题目描述：
 *    给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出
 *    needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 思路：找是否是子字符串，
 *   1.暴力求解直接遍历，（会遍历不必要的次数）
 *   2.用栈，将短的字符串入栈。(事实证明太麻烦)
 *   3.双指针(暴力求解)
 *      |--移动 pn 指针，直到 pn 所指向位置的字符与 needle 字符串第一个字符相等。
 *      |--通过 pn，pL，curr_len 计算匹配长度。
 *      |--如果完全匹配（即 curr_len == L），返回匹配子串的起始坐标（即 pn - L）。
 *      |--如果不完全匹配，回溯。使 pn = pn - curr_len + 1， pL = 0， curr_len = 0。
 *
 *   4.KMP算法：著名的字符串匹配算法
 *
 * 特殊情况考虑：
 *
 *
 * @Auther:sommer1111
 * @date 2020/8/4 16:25
 */
public class _08_04_strStr {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr(haystack,needle));

    }

    public static int strStr(String string,String target){
        int t = target.length();
        int s = string.length();
        if(s ==0){
             return 0;
         }

        int sfirst = 0;
        int cur = 0;
        for(;sfirst < s - t +1; sfirst = sfirst -cur+1,cur=0) {
            while(sfirst < s - t +1 && string.charAt(sfirst)!=target.charAt(0)){
                sfirst++;
            }
            int tfirst = 0;

            while(tfirst< t && sfirst< s && string.charAt(sfirst) == target.charAt(tfirst)){
                cur++;
                tfirst++;
                sfirst++;
            }
            if(cur== t){
                return sfirst- t;
            }
        }
        return -1;
    }

}
