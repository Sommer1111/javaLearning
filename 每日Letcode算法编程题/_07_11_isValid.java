import java.util.HashMap;
import java.util.Stack;

/**
 * 题目描述：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
 * 思路：
 * 1.暴力求解，无脑最难：（如果有空字符串，需要先去除）
 *  ① 括号总数必须为双数
 *  ② 外层遍历找左括号，内存再寻找另一只括号。同类型括号里面其它符号的个数不为双数、找不到则错。
 *   找到又需分情况讨论
 *    |---直接相邻，则继续下一个。
 *    |---
 *
 * 2.递归法 1
 * ① 遍历找括号的另一半，如果中途遇到了同类型的左括号，进入递归找另一半
 *
 * 3.递归法 2
 * 用 ”“ 代替成对的() {} [],但是错位的会判断失误{(})比如这样
 *
 * 4.用栈。类似于用栈实现中缀表达式
 *
 * 5.学到了，如果只有单种括号的话可以使用计数器。
 * 我在苦恼的是，遇到了一个括号，本来要找它的另一半，结果又出现新的左括号。
 * 计数就可以抵消这种差异性，一视同仁对待。
 *
 * 总结：
 * 1.遇到问题上来暴力求解一般都即繁杂又很多地方会出错。反而很难实现。
 * 2.算法大法好。掌握住核心的要点。
 *
 * @Auther:sommer1111
 * @date 2020/7/11 15:55
 */
public class _07_11_isValid {
    public static void main(String[] args) {
        String s = new String("(])");
        boolean valid = isValid(s);
        System.out.println(valid);

    }

    //1.用数组实现栈来实现。
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length()==0){//输入直接为空格的情况 ：“ ”
            return true;
        }
        //输入的第一个不是左括号可以直接判断为错
        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') {
            return false;
        }

        //一般情况就是遍历
        for (int i = 0; i < s.length(); i++) {
            //如果为左括号则入栈
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                //peek() 之前要判断一下栈是否为空，如当直接入 ']'时空栈异常
                if (stack.isEmpty()) {
                    return false;
                }
                //如果是右括号，则peek一下栈顶元素是否为一对，是则出栈，不是则return
                if ((s.charAt(i) == ')' && stack.peek() == '(') || (s.charAt(i) == '}' && stack.peek() == '{') || (s.charAt(i) == ']' && stack.peek() == '[')) {
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.empty();
    }

}

//2.用哈希表实现栈
class Solution{
    private HashMap<Character, Character> map;
    public Solution() {
        //key: 左括号，value:右括号
        this.map = new HashMap<Character, Character>();
        this.map.put(')', '(');
        this.map.put('}', '{');
        this.map.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.map.containsKey(c)) {//是右括号
                //栈 stack 为空： 此时 stack.pop() 操作会报错；因此给 stack 赋初值 ? ，
                // 并在哈希表中建立 key: '?'，value:'?'
                //此时当 stack 为空且 c 为右括号时，可以正常提前返回

                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != this.map.get(c)) {//判断栈顶是不是左括号
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
