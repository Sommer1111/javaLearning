package DataStructureTest.LinkedList;

/**
 *
 * 单向循环链表，实现约瑟夫问题的求解
 * @Auther:sommer1111
 * @date 2020/6/1 11:29
 */
public class CircleLinkedListDemo{
    public static void main(String[] args) {
        CircleLinkedList c = new CircleLinkedList();
        c.addPoint(10);
        c.showLinked();
        System.out.println(c.countPoint());        c.delPoint(2);
    }
}

//创建单向循环链表，包含各种方法及实现类
class CircleLinkedList{
    /**
     * 思路分析：
     * 1.创建一个头指针，为空
     * 2.添加
     *  2.1 需要一个辅助指针记住当前的节点，并在使用时挪到其他位置
     *  2.2 next指针的变化，永远指向第一个节点
     *  2.3 中间变量：temp
     */

    //新建一个空节点作为头指针的起始位置
    static Point first = null;
    public static void addPoint(int num){
        if(num<1){
            System.out.println("输入有误！");
        }

        //创建指针记住当前节点
        Point curPoint = null;
        for (int i = 1; i <num; i++) {
            //这里创建的是小孩的节点
            Point point  = new Point(i);
            //分加一个和加多个的情况
            if(i==1){//从 1 开始数
                first = point;
                first.setNext(first);//小孩节点不属于链表的部分，应该以first那条主线为准
                curPoint = first; //将当前指针移到现有位置
            }else{
                curPoint.setNext(point);//将新创建的节点加到链表，也就是最后一个链表的next指向新的节点
                point.setNext(first);//尾指针的next指向头节点，形成环状
                curPoint = point;//中间变量指向下一个节点

            }
        }
    }

    public static void showLinked(){
      if(first==null){
          System.out.println("当前链表为空");
      }else{
          //还是循环遍历，头节点不能动，需要中间变量移动指向。
          Point cur = first;
          while(true){
              System.out.print(cur.getNumber()+"--->");
              if(cur.getNext()==first){//遍历结束
                  System.out.println(first.getNumber());
                  break;
              }
              cur = cur.getNext();
          }
      }
    }

    //获取链表的节点数
    public static int countPoint(){
        int count=1;
        if(first==null){
           return 0;
        }else{
            Point cur = first;
            while(true){
                if(cur.getNext()==first){
                    break;
                }
                count++;
                cur = cur.getNext();
            }
        }
        return count;
    }

    /**
     * 小孩出圈实现，思路分析：
     * 1.报数相当于移next、出圈相当于删除
     * 2.需要中间变量temp 来辅助删除。因为每次都是重新开始计数，所以并不需要固定头节点
     * 3.通过遍历移动指针，找到删除的位置
     */

    public static void delPoint(int delNomber){
        //这里可以插入对输入数据的判断

        Point p = first;//毕竟我自己不能删除自己
        while(true){
            if(p.getNext()==first){//将辅助指针移到删除节点的前一个位置
                break;
            }
            p = p.getNext();
        }

        while(true){
            if(first==p){//删到只有一个元素时就删完了。
                System.out.printf("最后一个小孩是%d",p.getNumber());
                System.out.println();
                break;
            }
            for (int i = 0; i <delNomber-1; i++) {//将指针移到需要删除的位置
                first = first.getNext();
                p = p.getNext();
            }
            System.out.printf("第%d个小孩出圈",first.getNumber());
            System.out.println();
            first = first.getNext();//出圈,删除之后可以进入新一轮的报数
            p.setNext(first);
        }
    }

}

//为环形链表创建节点类，当前的编号即为自己。
class Point{
    private int number;
    private Point next;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Point getNext() {
        return next;
    }

    public void setNext(Point next) {
        this.next = next;
    }

    public Point(int number) {
        this.number = number;
    }
}

