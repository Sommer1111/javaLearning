package DataStructureTest;

/**
 * 栈的分析：先进后出
 * 用数组实现：maxSize、index(初始为-1)
 * @Auther:sommer1111
 * @date 2020/6/9 20:04
 */
public class StackTest {
    public static void main(String[] args) {
        //数组实现的测试
//        Stack stack = new Stack(5);
//        stack.push(5);
//        stack.push(4);
//        stack.push(7);
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.show();
//        System.out.println("出栈之后");
//        stack.pop();
//        stack.show();

        //单链表实现的测试
        LinkedStack l = new LinkedStack();
        Point1 point1 = new Point1(1);
        Point1 point2 = new Point1(2);
        Point1 point3 = new Point1(3);
        l.push(point1);
        l.push(point2);
        l.push(point3);
        l.show();


    }

}

//用数组实现栈
class Stack{
    private int maxSize;
    private int[] stack;
    private int index=-1;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    public boolean isEmpty(){
        return index==-1;
    }

    public boolean isFull(){
        return index+1==maxSize;
    }

    //进栈：判断是否栈满+索引后移
    public void push(int number){
        if(isFull()){
            System.out.println("栈已满，无法进栈");
        }else{
            index++;
            stack[index] = number;
        }
    }

    //出栈：判断栈是否为空
    public int pop(){
        if(isEmpty()){
           throw new RuntimeException("栈为空，无法出栈！");
        }else{
            int temp = stack[index];
            index--;
            return temp;
        }
    }

    //显示整个栈
    public void show(){
        if(isEmpty()){
            System.out.println("栈为空");
        }else{
            for (int i = index; i >= 0 ; i--) {
                System.out.printf("Stack[%d] = %d",i+1,stack[i]);
                System.out.println();
            }
        }
    }
}

//用单链表来实现栈
class LinkedStack{
    private Point1 head = new Point1(0);//创建头指针

    //判断空栈
    public boolean isEmpty(){
        return head.next==null;
    }

    //入栈，头指针不能动，需要中间变量
    //这里问题：每一次新加都像重新开始，所以只加进去了一个数据，全局和局部的区别
    public void push(Point1 p){
        if(isEmpty()){
            head.next = p;//空的时候直接佳
        }else{//因为要实现栈，所以相当于是插入操作
           p.next = head.next;//有元素，因为temp指向当前位置，所以放到temp.next
           head.next = p;//再把temp指针后移，指向当前最后一个节点
        }


    }
    //出栈
    //显示全栈
    public void show(){
        Point1 temp1 = head;
        boolean flag = true;
        while(flag){
            System.out.println(temp1.next);
            temp1 = temp1.next;
            flag = (temp1.next !=null);
        }
    }

}

class Point1{
     Point1 next;
     int value;

    public Point1(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Point1{" +
                "value=" + value +
                '}';
    }
}
