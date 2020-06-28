import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目描述：
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。
     * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * 输出：true
 *
 * 思路：
 *  1.把所有可能的情况计算出来，然后再对比——时间复杂度太高，不可行
 *  2.观察两个序列的特点 pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 *  for循环遍历序列
 *     |--pop组遍历第一个4，为第一次入栈的终点，第一次操作入栈[1,2,3,4]
 *        得到栈[4，3，2，1],弹出4，栈里顺序为[3,2,1]，弹出栈[4]
 *     |--pop组遍历第二个5，在已入栈里面没有，则执行第二次入栈[5](入栈的个数)，得到
 *      [5,3,2,1],弹出5，栈里顺序为[3，2，1]，弹出栈[4,5]
 *     |--pop组遍历第3个，已入栈里面有，peek一下看是不是它，是则出栈，不是则返回false
 *
 *  学习：贪心算法：
 *  先把所有的值push进去，push的同时，peek一下栈顶元素，是就pop，不是就继续push，对比顺序
 *
 * @Auther:sommer1111
 * @date 2020/6/24 18:45
 */
public class _08_JudegPopSequences {
    public static void main(String[] args) {
        int[] pushed ={1,2,3,4,5};
        int[] poped = {4,5,3,1,2};
        System.out.println(validateStackSequences(pushed,poped));
        System.out.println(validateStackSequences2(pushed,poped));

    }

    //此方法泰国繁琐，并且自己找不到出错的地方在哪
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack stack = new Stack();
        int popmax = 0;//记录已经push进去的最大长度
        for (int i = 0; i < pushed.length; i++) {
            if(i ==0){
                int num = popped[i];
                int o = findindex(pushed, num);
                for (int j = 0; j < o; j++) {
                    stack.push(pushed[j]);
                    popmax++;
                    stack.pop();
                }
                list.add(num);

            }else{
                int num2 = popped[i];
                if(stack.search(num2) != -1){
                    //System.out.println(num2);
                    if( (int)stack.peek()!=num2){
                        return false;
                    }else{
                        System.out.println("dayin");
                        list.add((int)stack.pop());
                    }
                }else{
                    int o2 = findindex(pushed, num2);//要找到该点的索引值,注意从哪里开始
                    for (int j =popmax; j <= o2; j++) {
                        stack.push(pushed[j]);
                        if(j==o2){
                            list.add((int)stack.pop());
                        }
                    }

                }
            }
        }

        System.out.println(list);

        //判断得出的出栈顺序是否一致
//        for (int i = 0; i < popped.length; i++) {
//            if(list.get(i)!=popped[i]){
//                return false;
//            }
//
//        }
        return true;

    }

    //找到某一元素在该数组中的索引
    public static int findindex(int[] arr,int num){
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] ==num){
                index=i;
            }
        }
        return index;
    }


    //int[] pushed = {1,2,3,4,5};
    //int[] poped =  {4,5,3,1,2};
    //从入栈的角度考虑出栈的问题。而我是从出栈考虑入栈，换一个角度
    public static boolean validateStackSequences2(int[] pushed, int[] popped) {
        int length = pushed.length;
        Stack<Integer> stack = new Stack<>();

        int j = 0;
        for(int i :pushed){
            stack.push(i);
            while( !stack.isEmpty() && j<length && stack.peek()==popped[j]){
                stack.pop();//只要入栈的数与出栈栈顶数相同就出栈，如果完全符合，最后
                //肯定都pop出来了，没有pop出来就说明有问题。贪心算法，不拘泥于细节。
                j++;
            }

        }
        return j==length;
    }
}
