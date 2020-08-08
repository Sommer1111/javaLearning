import java.util.ArrayList;

/**
 * 题目描述：
 *   给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。每一项将表示为一个字符串
 *   如：[1, 11, 21, 1211, 111221, 312211, 13112221]
 * 分析：
 *   暴力求解，一次成功，无算法
 *   时间复杂度：O(n^2)
 *   空间复杂读度：O(n)
 *
 *   执行用时：23 ms,在所有 Java 提交中击败了 12.89% 的用户
 *   内存消耗：40.1 MB,在所有 Java 提交中击败了 12.24% 的用户
 *
 * 使用 StringBuffer之后 :
 *   执行用时：10 ms,在所有 Java 提交中击败了 26.97% 的用户
 *   内存消耗：37.1 MB,在所有 Java 提交中击败了 48.59% 的用户
 *
 * @Auther:sommer1111
 * @date 2020/8/6 11:28
 */
public class _08_06_countAndSay {

    public static void main(String[] args) {

        System.out.println(countAndSay(10));
    }

    public static String countAndSay(int n) {
        ArrayList<String> list = new ArrayList<>();
        if(n==0){
            return "1";
        }

        list.add("1");
        for (int i = 0; i <n ; i++) {
            String s = list.get(i);//是不是因为没有初始化长度所以报错？
            int count=1;
            //String addString="";
            StringBuffer res = new StringBuffer();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(j+1<s.length() && s.charAt(j+1) ==c){
                    count++;
                }else{
                    //addString = addString+count+s.charAt(j);
                    res.append(count).append(s.charAt(j));
                    count=1;

                }
            }
            //list.add(addString);
            list.add(res.toString());
        }

        System.out.println(list);
        return list.get(n-1);

    }

    //用 StringBuffer 和递归 提高效率
    //StringBuffer变量比较节省空间，不用重新开辟空间。
    //String str = “hello”;str = str+"world";直接是重新开辟一块空间

    public String countAndSay2(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuffer res = new StringBuffer();
        String str = countAndSay(n - 1);
        int length = str.length();
        int a = 0;
        for (int i = 1; i < length + 1; i++) {
            if (i == length) {
                return res.append(i - a).append(str.charAt(a)).toString();
            } else if (str.charAt(i) != str.charAt(a) ) {
                res.append(i - a).append(str.charAt(a));
                a = i;
            }
        }
        return res.toString();
    }
}
