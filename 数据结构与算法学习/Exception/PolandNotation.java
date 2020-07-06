package DataStructureTest;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

/**
 * 要求：用逆波兰表达式实现计算
 * 思路：
 *  1.中缀表达式转后缀表达式：
 *      1) 初始化两个栈：运算符栈s1和储存中间结果的栈s2；
 *      2) 从左至右扫描中缀表达式；
 *      3) 遇到操作数时，将其压s2；
 *      4) 遇到运算符时，比较其与s1栈顶运算符的优先级：
 *         (1) 如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
 *         (2) 否则，若优先级比栈顶运算符的高，也将运算符压入s1；
 *         (3) 否则，将s1栈顶的运算符弹出并压入到s2中，
 *             再次转到(4-1)与s1中新的栈顶运算符相比较
 *      5) 遇到括号时：
 *          (1) 如果是左括号“(”，则直接压入s1
 *          (2) 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
 *      6) 重复步骤2至5，直到表达式的最右边
 *      7) 将s1中剩余的运算符依次弹出并压入s2
 *      8) 依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达
 *
 *  2.中缀表达式的计算规则：从左至右扫描后缀表达式栈，遇到符号，弹出数字计算再入栈
 *
 *  总结：
 *  1.判断！=，这里出错，因为是String类型所以只能使用equal 来判断
 *  2.无限循环不终止，原来是因为index忘记++
 *  3.后缀表达式的思路，主要是两个数字入栈配一个符号在后面，优先级高的先入表达式。
 * @Auther:sommer1111
 * @date 2020/6/22 18:42
 */
public class PolandNotation {
    //1.获取后缀表达式，并将它转化成list保存便于遍历——>抽象出 getList方法
    //2.索引读取入栈————>抽象出 geResult 方法
    public static void main(String[] args) {
        MidToPolandNotation mid = new MidToPolandNotation();
        String s = "( 30 - 10 ) / 5 - 6 * 3";// -14
        System.out.println("中缀表达式为："+ s);
        ArrayList<String> list = getList(s);
        ArrayList<String> poland = mid.getPoland(list);
        int res = getResult(poland);
        System.out.println();
        System.out.println("计算结果="+res);
    }

    public static ArrayList<String> getList(String s){
        String[] ex = s.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for(String ele:ex){
            list.add(ele);
        }
        return list;
    }

    public static int getResult(ArrayList<String> list){
        int res = 0;
        Stack<String> stack = new Stack<>();
        for(String ele: list){
            if(ele.matches("\\d+")){//正则表达式，匹配一个或多个数字
                stack.push(ele);
            }else{
                int numb1 = Integer.parseInt(stack.pop());
                int numb2 = Integer.parseInt(stack.pop());
                if(ele.equals("+")){
                    res = numb1+numb2;
                }else if(ele.equals("-")){
                    res = numb2-numb1;
                }else if(ele.equals("*")){
                    res = numb1*numb2;
                }else{
                    res = numb2/numb1;
                }
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }

}



//实现中缀表达式转后缀表达式
class MidToPolandNotation{

    public static ArrayList<String> getPoland(ArrayList<String> list){
        Stack<String> stack1 = new Stack<>();//1) 初始化两个栈：运算符栈s1和储存中间结果的栈s2；
        Stack<String> stack2 = new Stack<>();
        //分情况讨论

        int index = 0;
        do{
            String ele = list.get(index);// 2) 从左至右扫描中缀表达式；
            if(ele.matches("\\d+")){//3) 遇到操作数时，将其压s2；
                stack2.push(ele);
                index++;
            }else{// 4) 遇到运算符时，比较其与s1栈顶运算符的优先级：
                if(stack1.empty()||ele.equals("(")){
                    // (1) 如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
                    stack1.push(ele);
                    index++;
                }else if(ele.equals(")")){//5) 遇到括号时：
                   while(!stack1.peek().equals("(")){//用 != 判断不了，这里是String类型
                       //(2) 如果是右括号“)”，则依次弹出s1栈顶的运算符，
                       // 并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                       stack2.push(stack1.pop());
                    }
                   stack1.pop();//优秀！这样就把括号去掉了！
                   index++;

                } else if(firstOrNot(ele)>firstOrNot(stack1.peek())){
                    // (2) 否则，若优先级比栈顶运算符的高，也将运算符压入s1；
                    stack1.push(ele);
                    index++;
                }else{
                    // (3) 否则，将s1栈顶的运算符弹出并压入到s2中，
                    // 再次转到(4-1)与s1中新的栈顶运算符相比较
                    stack2.push(stack1.pop());

                }
            }

        } while(index < list.size());//6) 重复步骤2至5，直到表达式的最右边

        while(!stack1.empty()){// 7) 将s1中剩余的运算符依次弹出并压入s2
            stack2.push(stack1.pop());

        }

        ArrayList<String> newNotation =new ArrayList<>();
        System.out.print("后缀表达式为：");
        for(String ele:stack2){
            //8) 依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达
           newNotation.add(ele);
           System.out.print(ele+" ");

        }

        return newNotation;
    }

    //判断优先级
    public static int firstOrNot(String s){
        int i = 0;
        switch(s){
            case "+":
                i = 1;
                break;
            case "-":
                i = 1;
                break;
            case "*":
                i = 2;
                break;
            case "/":
                i = 2;
                break;
        }
        return i;
    }
}
