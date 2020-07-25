import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 题目描述：输入罗马数字，输出阿拉伯表达的数。注意特俗情况，IV=4，IX=9。。。。
 *
 * 分析：
 *   透过现象看本质：把小值放在大值左边就做减法， 否则做加法，IV=4，VI=6.
 *
 *  解题思路：
 *  1. 找到适合的方法很重要，开始我选择的是栈，一种一种情况分析讨论，一直出现空栈、越界等问题
 *  实在是头疼，换一个示例就出问题，代码健壮性极差。
 *  2. 参考他人思路，发现那些情况根本上还是左右的位置对应加减的情况。
 *  3.用 HashMap 一一映射，可以很快的得到对应的值。
 *    在实际测试中发现，用 switch 会比 HashMap快很多
 *
 *   总结：
 *   1.题目该用何种方法解答：栈、HahMap、链表。。。。。
 *   2.透过表面看本质
 *
 * @Auther:sommer1111
 * @date 2020/7/25 16:50
 */
public class _07_25_RomanToInt {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        int i = romanToInt1(s);
        System.out.println(i);
    }

    public static int  romanToInt1(String s){
        Map<Character,Integer> map = new HashMap();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int res = 0;

        for (int i = 0; i < s.length()-1; i++) {
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                res -= map.get(s.charAt(i));
            }else{
                res += map.get(s.charAt(i));
            }
        }
        res += map.get(s.charAt(s.length()-1));//没有下一位时，直接加上

        return res;

    }

    public static int romanToInt2(String s){
        int res = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));//全部元素入栈
        }

       // System.out.println(stack);

        while(!stack.isEmpty() && (stack.peek() =='I' || stack.peek() == 'V')){
            char c1 = stack.pop();
            if(c1 == 'I'){
                res+=1;
            }else if(c1=='V' && stack.peek()=='I'){
                stack.pop();
                res+=4;//IV=4 情况
            }else{
                res+=5;
            }
        }

        while(!stack.isEmpty() && (stack.peek() =='X' || stack.peek() == 'L')){
            char c2 = stack.pop();
            if(c2 == 'X' && stack.peek() == 'I'){
                stack.pop();
                res+=9; //IX=9 情况
            }else if(c2=='L' && stack.peek()=='X'){
                stack.pop();//XL =40 情况
                res+=40;
            }else{
                if(c2=='X'){
                    res+=10;
                }else{
                    res+=50;
                }

            }
        }

        while(!stack.isEmpty() && (stack.peek() =='C' || stack.peek() == 'D')){
            char c3 = stack.pop();
            if(c3 == 'C' && stack.peek() == 'X'){
                stack.pop();
                res+=90; //XC=9 情况
            }else if(c3=='D' && stack.peek()=='C'){
                stack.pop();//CD =400 情况
                res+=400;
            }else{
                if(c3=='C'){
                    res+=100;
                }else{
                    res+=500;
                }

            }
        }

        while (!stack.isEmpty() && (stack.peek() == 'M' && stack.size() != 0)) {
            char c4 = stack.pop();
            if(stack.size()==0){
                return res += 1000;
            } else if (c4 == 'M' && stack.peek() == 'C') {
                stack.pop();
                res += 900; //XC=9 情况
            }
        }
        return res;
    }
}


