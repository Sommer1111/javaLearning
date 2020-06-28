import java.util.ArrayList;
import java.util.Stack;

/**
 * ��Ŀ������
 * ���������������У���һ�����б�ʾջ��ѹ��˳��
 * ���жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
     * ���룺pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * �����true
 *
 * ˼·��
 *  1.�����п��ܵ�������������Ȼ���ٶԱȡ���ʱ�临�Ӷ�̫�ߣ�������
 *  2.�۲��������е��ص� pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 *  forѭ����������
 *     |--pop�������һ��4��Ϊ��һ����ջ���յ㣬��һ�β�����ջ[1,2,3,4]
 *        �õ�ջ[4��3��2��1],����4��ջ��˳��Ϊ[3,2,1]������ջ[4]
 *     |--pop������ڶ���5��������ջ����û�У���ִ�еڶ�����ջ[5](��ջ�ĸ���)���õ�
 *      [5,3,2,1],����5��ջ��˳��Ϊ[3��2��1]������ջ[4,5]
 *     |--pop�������3��������ջ�����У�peekһ�¿��ǲ������������ջ�������򷵻�false
 *
 *  ѧϰ��̰���㷨��
 *  �Ȱ����е�ֵpush��ȥ��push��ͬʱ��peekһ��ջ��Ԫ�أ��Ǿ�pop�����Ǿͼ���push���Ա�˳��
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

    //�˷���̩�������������Լ��Ҳ�������ĵط�����
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack stack = new Stack();
        int popmax = 0;//��¼�Ѿ�push��ȥ����󳤶�
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
                    int o2 = findindex(pushed, num2);//Ҫ�ҵ��õ������ֵ,ע������￪ʼ
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

        //�жϵó��ĳ�ջ˳���Ƿ�һ��
//        for (int i = 0; i < popped.length; i++) {
//            if(list.get(i)!=popped[i]){
//                return false;
//            }
//
//        }
        return true;

    }

    //�ҵ�ĳһԪ���ڸ������е�����
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
    //����ջ�ĽǶȿ��ǳ�ջ�����⡣�����Ǵӳ�ջ������ջ����һ���Ƕ�
    public static boolean validateStackSequences2(int[] pushed, int[] popped) {
        int length = pushed.length;
        Stack<Integer> stack = new Stack<>();

        int j = 0;
        for(int i :pushed){
            stack.push(i);
            while( !stack.isEmpty() && j<length && stack.peek()==popped[j]){
                stack.pop();//ֻҪ��ջ�������ջջ������ͬ�ͳ�ջ�������ȫ���ϣ����
                //�϶���pop�����ˣ�û��pop������˵�������⡣̰���㷨����������ϸ�ڡ�
                j++;
            }

        }
        return j==length;
    }
}
