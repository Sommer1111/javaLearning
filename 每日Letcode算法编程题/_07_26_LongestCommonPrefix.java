/**
 * 题目描述：
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""
 *
 * 思路：
 * 1.将一个字符串作为基准，一个一个字符串对比，更新基准字符串。
 *
 * 总结：
 * 1.开始使用{"flower","flowe","flow"}奇怪为什么一直没有进入这个判断
 *   原来是因为例子本身的特殊性就不会进入
 * 2. 复制过来别人可以实现的代码对比，有些不同，不过再一次印证我：代码的世界没有标准答案
 * 3.可学习参考：for语句的这种使用：
 *      int j = 0;
 *      for(;j<res.length() && j<strs[i].length();j++){}
 *
 * @Auther:sommer1111
 * @date 2020/7/26 16:01
 */
public class _07_26_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"aa","a"};
        System.out.println(longestCommonPrefix(strs));
    }

    public  static String longestCommonPrefix(String[] strs) {

        if(strs.length==0 || strs==null){
            return "";
        }

        String res = strs[0];
        for (int i =1; i < strs.length; i++) {
            int j = 0;//还有这种操作，拿出来每次就可以实现归零，从头开始对比。
            for(;j<res.length() && j<strs[i].length();j++){
                if(res.charAt(j) != strs[i].charAt(j)){
                    //开始使用{"flower","flowe","flow"}奇怪为什么一直没有进入这个判断
                    //原来是因为例子本身的特殊性就不会进入
                    //复制过来别人可以实现的代码对比，再一次印证我：代码的世界没有标准答案
                   break;//放在外面还是很有道理的，当字符串只有一位时，无法进入这个判断
                }
            }
            res = res.substring(0,j);
            if(res.length()==0){
                return "";
            }
        }
        return res;
    }
}
