package DataStructureTest.Exception;

/**
 * 入栈中缀表达式法实现计算： 2*5+2/3-5
 * 思路：
 * 1.读出(index)表达式(String)的数字和符号----->这个思路可以借鉴，读取字符串里的数字
 * 2.对符号的情况进行讨论判断
 *   2.1 如果符号栈为空，则直接入栈
 *   2.2 如果不为空
 *       2.2.1 判断想入的符号，如果符号的优先级高，则直接入
 *       2.2.2 如果优先级相等或更低，则先出栈计算再入栈
 *         ----| 数字栈出两个数字，符号栈出一个符号，运算出结果，将结果入数字栈
 *         ----| 将符号入栈
 *
 * 总结：
 * 1.之前在看字符串和字符的区别，一直说，字符可以相当于一个整型数字，可以参加表达式时计算
 * 当时疑惑，那这样的话不是所有的字符都不就是变相的数，这不是乱了吗？
 * 思考对比：
 *        System.out.println(2+'*'); //44
 *        System.out.println('*'); //*
 * 这个一运算，现在才明白过来，char相当于ASCII版本下的一个数，可以直接拿来用，
 * 当char作为表达式整型计算时，就是默认符号 如 1*3 中的 * ，就只是一个符号。
 * 当char不是作为表达式，如，1 + * 这样，参与计算就会转换成ASCII值来进行运算。
 *
 * 2.判断优先级实际上就是实现优先级的运算：
 * 当式子中出现 * / 时本来就需要先把它们看成一个整体先计算出来，转换成所有的同级运算
 * 最后都是同优先级的就可以不用考虑先后的问题。
 *
 * 3.考虑多位数，需要在index时考虑后一个数是否依旧是数字，然后拼接。
 * 注意：
 *    ---多位数拼接index也要相应的变化，不然会重复计算
 *    ---拼接使用的中间变量要清零，不然会越来越长
 *
 * 4.考虑小括号、大括号存在时的继续分类讨论。
 * 
 * @Auther:sommer1111
 * @date 2020/6/11 17:32
 */
public class MidExepressionDemo {
    public static void main(String[] args) {
        //创建表达式，符号栈、数字栈
        String s = "7*12-8/4";
        Stack2 numStack = new Stack2(10);
        Stack2 operaStack = new Stack2(10);

        //创建出你需要的变量
        int index = 0;//作为读取表达式每一个字符的指针
        String temp = "";//用来处理多位数的拼接
        int num1 = 0;//用于计算
        int num2 = 0;//用于计算
        int oper = 0;//用于存储表达式
        int res = 0; //用于存储计算结果

        //循环读取表达式的每一位
        while (true) {
            char c = s.substring(index, index + 1).charAt(0);//读取出字符串，可以学习
            if (c == '*' || c == '/' || c == '+' || c == '-') {
                //如果为空直接入栈
                if (operaStack.isEmpty()) {
                    operaStack.push(c);
                } else {//读字符：如果不为空，分两种优先级情况，此时需要知到栈顶字符的优先级
                    if (priority(operaStack.topnum()) < priority(c)) {//如果优先级高直接入
                        operaStack.push(c);
                    } else {//优先级低或相等，先出栈计算（这里相等放到上面的情况去了，导致计算错误）
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operaStack.pop();
                        res = cal(num1, num2, oper);

                        numStack.push(res);
                        operaStack.push(c);
                    }
                }
            } else {//读数字
                temp += c;

                //补充多位数的读取
                if(index < s.length()-1){//先判断有没有下一位数
                    char next = s.substring(index+1,index+2).charAt(0);
                    if(next >47 && next<58){//数字的ASCII对应：0:48，9:57，即下一个数仍为数字
                        temp += next;
                        index++;//这里拼接的过程读取了多位数，所以相应的index也要改变不然会重复读取
                    }
                }
                numStack.push(Integer.parseInt(temp));
                temp ="";//注意！拼接要归零！
            }

            index++;
            if (index > s.length() - 1){
                break;
            }
        }
            //读完循环运算，直至只剩下一个结果
            while (true) {
                if (operaStack.isEmpty()) {
                    System.out.println(numStack.pop());
                    break;
                }

                num1 = numStack.pop();
                num2 = numStack.pop();
                oper = operaStack.pop();
                res = cal(num1, num2, oper);
                numStack.push(res);

                //我这样去判断当栈只有一个数时在后面，所以最后一步操作只有一个数时仍进行了pop操作，所以报错
//            if(numStack.onlyone()){
//                System.out.println(numStack.pop());
//                break;
//            }
            }

    }


    //判断优先级
    public static int priority(int c){
        if(c =='*' || c == '/' ){
            return 1;
        }else if(c == '+' || c == '-'){
            return -1;
        }else{
            return 0;
        }
    }

    //操作数
    public static int cal(int num1,int num2,int exp){
        int res = 0;
        switch (exp){
            case '+':
                res = num1+num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1*num2;
                break;
            case '/':
                res = num2/num1;
                break;
        }
        return res;
    }
}

class Stack2{
    private int[] arr;
    private int index=-1;//做为索引
    private int maxSize;

    public Stack2(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isEmpty(){
        return index ==-1;
    }

    public boolean isFull(){
        return index == maxSize-1;
    }

    public void push(int num){
        if(isFull()){
            System.out.println("栈已满！");
        }else{
            index++;
            arr[index] = num;
        }
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空！");
        }else{
          int temp = arr[index];
          index--;
          return temp;
        }
    }

    public void show(){
        int len = arr.length-1;
        for (int i = len; i >= 0 ; i--) {
            System.out.println(arr[i]);
        }
    }

    //在原有栈的基础上增加功能
    //返回栈顶的字符，让新加的字符可以与之比较优先级
    public int topnum(){
        return arr[index];
    }

    //判断栈是否只有一个元素
    public boolean onlyone(){
        return arr.length==1;
    }
}

