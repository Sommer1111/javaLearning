package DataStructureTest.Queue;

import java.util.Scanner;

/**
 * 成功实现
 * 总结：
 * 1.列表队列时，遍历的起始位置要注意是front+1
 * 2.在判断非空时，第一选择是输出打印信息，发现程序会
 *   继续往后执行，导致indexOutOfBoundsException，所以需要用throw
 * 3.在判断非空、队满时如果就写入抛异常，后面加数据加不进去。
 *
 * @Auther:sommer1111
 * @date 2020/5/24 10:07
 */
public class QueueArrayTest {
    public static void main(String[] args) {
        QueueArray queue = new QueueArray();
        //演示操作
        boolean b = true;
        do{
            System.out.println();
            System.out.println("1-列表队列");
            System.out.println("2-增加数据");
            System.out.println("3-弹出数据");
            System.out.println("4-取头数据");
            System.out.println("5-退出");
            Scanner s = new Scanner(System.in);
            int i = s.nextInt();
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
                        queue.headQueue();
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

class QueueArray {
    //1.创建几个基本的变量，来表示这个队列
    private int front = -1;
    private int rear = -1;
    private int maxSize;
    private int[] arr ;

    //2.构造函数，创建出队列数组
    public QueueArray() {
        //1.获取需要创建的数组的maxSize的大小
        Scanner s = new Scanner(System.in);
        System.out.print("请输入队列的大小：");
        maxSize = s.nextInt();
        arr = new int[maxSize];
    }

    //实现各类方法：加数据、输出数据、判断非空、未满

    //3.判断队列是否为空
    public boolean isNull(){
        return front == rear;
        }

    //4.判断队列是否已满
    public boolean isFull(){
        return rear+1 ==maxSize;
    }

    //5.加数据
    public void addQueue(int i){
        //如果未满，加入
        if(isFull()){
            //如果这里不抛异常只是打印的话，后面执行arr[rear]=i会报错
            throw new RuntimeException("队列已满！无法继续添加~");
        }
        //指针后移，再把该位置的数字安排上
        rear++;
        arr[rear] = i;
    }

    //6.取出数据
    public void poopQueue(){
        if(isNull()){
            throw new RuntimeException("队列已空!无法取出数据~");
        }
        //front 指针指向头数据前一个位置
        front++;
        System.out.println("取出的数据是："+ arr[front]);

    }

    //列表数据
    public void liStQueue(){
        if(isNull()){
            throw new RuntimeException("队列为空!无法显示列表~");
        }

        //这里注意从front+1开始
        for (int j = front+1; j <arr.length ; j++) {
            System.out.printf("arr[%d]=%d\n",j,arr[j]);
        }
        System.out.println();

    }

    //取出头数组
    public int headQueue(){
        if(isNull()){
            throw new RuntimeException("队列为空！没有头数据~");
        }
        return arr[front+1];
    }
}

