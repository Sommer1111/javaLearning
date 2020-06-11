package DataStructureTest;

import java.util.Scanner;

/**
 * 成功实现
 * 总结：
 * 1.要先完全搞懂这个变化的思路，再来实现就快了
 * 2.在显示列表的时候，没有注意到，增长的范围应该是: front ~ front+queueSize()
 *
 * @Auther:sommer1111
 * @date 2020/5/24 15:52
 */
public class CircleQueueArray {
    public static void main(String[] args) {
        Circle queue = new Circle();
        //演示操作
        boolean b = true;
        do{
            System.out.println();
            System.out.println("1-列表队列");
            System.out.println("2-增加数据");
            System.out.println("3-弹出数据");
            System.out.println("4-取头数据");
            System.out.println("5-退出");
            System.out.print("请输入选择：");
            int i = new Scanner(System.in).nextInt();
            switch(i){
                case 1:
                    try {
                        queue.liStQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("请输入要添加的数据：");
                    try {
                        queue.addQueue(new Scanner(System.in).nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 3:
                    try {
                        queue.poopQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println(queue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    b = false;
                    break;
            }
        }while(b);
    }
}



class Circle{
    private int front;
    private int rear;
    private int maxSize;
    private int[] arr;

    public Circle() {
        front = 0;
        rear = 0;
        System.out.print("请输入队列的大小：");
        maxSize = new Scanner(System.in).nextInt();
        arr = new int[maxSize];
    }

    //区别在于，此时front指向首数据
    //rear指向最后数据的后一位， 也就是留出一个空位来区分空和满队
    //判断是否为空：front ==rear
    //判断是否为满：（rear+1）% maxSize == front
    //输出列表时要判断它的有效个数

    //3.判断队列是否为空
    public boolean isNull(){
        return front == rear;
    }

    //4.判断队列是否已满
    public boolean isFull(){
        return (rear+1) % maxSize ==front;
    }

    //5.判断队列的长度
    public int queueSize(){
        return (rear-front+maxSize) % maxSize;
    }

    //6.加数据
    public void addQueue(int i){
        //如果未满，加入
        if(isFull()){
            throw new RuntimeException("队列已满！无法继续添加~");
        }
        //指针后移，这是需要考虑rear指针回到从0开始的情况，怎么变？
        arr[rear] = i;
        rear = (rear+1) % maxSize;
    }

    //7.取出数据
    public void poopQueue(){
        if(isNull()){
            throw new RuntimeException("队列已空!无法取出数据~");
        }
        //front 指针指向头数据,并且也可能循环到队头
        System.out.println("取出的数据是："+ arr[front]);
        front = (front+1) % maxSize;

    }

    //列表数据
    public void liStQueue(){
        if(isNull()){
            throw new RuntimeException("队列为空!无法显示列表~");
        }

        //这里注意j<front+queueSize而不是单纯的queueSize()
        for (int j = front; j <front+queueSize() ; j++) {
            System.out.printf("arr[%d]=%d\n",j,arr[j]);
        }
        System.out.println();
    }

    //取出头数组
    public int headQueue(){
        if(isNull()){
            throw new RuntimeException("队列为空！没有头数据~");
        }
        return arr[front];
    }
}
