package DataStructureTest.LinkedList;

import java.util.Stack;

/**
 * 实现单链表的增删查改操作
 *  思路：
 *     1.创建类，包含各种属性
 *     2.创建该类的增、删、查、改、遍历各类方法
 *     3.补充，判断该链表是否为空
 *
 *     总结：
 *     1.链表为空，但是需要返回值时可以return null
 *     2.链表为空不需要返回值时return；(或者理解为直接返回)
 *
 * @Auther:sommer1111
 * @date 2020/5/28 17:07
 */
public class SingLinkedListDemo {
    public static void main(String[] args) {
        //每一个对象里面存储了指向的下一个对象，这里的next并不是指针，而是该类的实例化对象
        //为单向行驶，所以必须有个头指针找到起始位置
        HeroLink hero1 = new HeroLink(1,"白起","战神");
        HeroLink hero2 = new HeroLink(2,"商鞅","立法");
        HeroLink hero3 = new HeroLink(3,"赢渠梁","明君");
        HeroLink hero4 = new HeroLink(4,"李白","诗仙");
        HeroLink hero5 = new HeroLink(5,"辛弃疾","爱国");
        SingLinkedList.add(hero1);
        SingLinkedList.add(hero3);
        SingLinkedList.add(hero2);
        SingLinkedList.add(hero5);
        SingLinkedList.add(hero4);

        System.out.println("这是第一次遍历的链表：");
        SingLinkedList.list();

        System.out.println();
        System.out.println("这是倒序输出的测试：");
        SingLinkedList.reverseOutput();

        System.out.println();
        System.out.println("这是删除之后的链表：");
        SingLinkedList.del(4);
        SingLinkedList.list();

        System.out.println();
        System.out.println("这是更新之后的链表：");
        SingLinkedList.update(new HeroLink(2, "商君", "变法"));
        SingLinkedList.list();

        System.out.println();
        System.out.println("这是输出倒数k的测试：");
        System.out.println(SingLinkedList.findIndex(2));

        System.out.println();
        System.out.println("这是将整个链表反转的测试：");
        SingLinkedList.reverseLink();


    }
}

class SingLinkedList{
    //首先创建一个空的头指针,注意头指针是不能动的
    private static  HeroLink head = new HeroLink(0,"","");

    //按编号增加的操作：
    //1.遍历找插入的位置：为空时直接插在尾部，不为空时需要另外确定
    //2.插入操作
    public  static void  add(HeroLink heroLink){
        HeroLink temp = head;
        boolean flag = false;

        //1.遍历判断找插入位置
        //如果不设置temp这个在中间变量，遍历输出的时候会找不到第一个元素
        //如果不另外设置flag，而是将两个操作混杂在一起，结构重复，要在空时、正确的位置均添加一遍
        while(true){
            if(temp.next == null){//链表为空，直接添加在尾部
                break;
            }
            if(temp.getNumber() ==heroLink.getNumber()){
                flag = true;//表示此时不能插入值
                break;
            }else if(heroLink.getNumber()<temp.next.getNumber()){//找到插入的位置
                break;
            }
            temp = temp.next;
        }

        //2.按flag的值来确定插入的操作
        if(flag){
            System.out.println("该编号的英雄已经存在，无法添加！");
        }else{
            //把temp的next指向这个新加的数，新加的数的next指向原来的next
            heroLink.next = temp.next;
            temp.next = heroLink;
        }


    }

    public static void list(){
        //遍历输出
        //1.遍历判断
        //2.输出操作
        HeroLink temp = head;
        if(head.next ==null){
            System.out.println("链表为空~");
            return;
        }
        while(true){
            if(temp.next ==null){
                break;
            }
            System.out.println(temp.next);//不然输不出最后一个
            temp = temp.next;
        }
    }

    //删除操作
    //1.遍历找位置，找到标志改为true
    //2.删除操作
    public static void del(int number){
        HeroLink temp = head;
        boolean flag1 = false;

        while(true){
            if(temp.next ==null){
                break;//
            }
            if(temp.next.getNumber() ==number){
                flag1 = true;
                break;
            }
            temp = temp.next;//后移

        }

        if(flag1){
            temp.next = temp.next.next;
        }else{
            System.out.println("该编号的英雄不存在！");
        }

    }

    //修改操作
    //1.遍历找元素
    //2.执行修改操作
    public static void update(HeroLink heroLink){
        HeroLink temp = head;
        boolean flag = false;

        while(true){
            if(temp.next==null){
                break;
            }
            if(temp.getNumber() ==heroLink.getNumber()){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.setName(heroLink.getName());
            temp.setNikename(heroLink.getNikename());
        }else{
            System.out.println("需要更改的英雄不存在。");
        }

    }

    //以下是一些单链表的面试题
    /**
    单链表的常见面试题有如下:
     1) 求单链表中有效节点的个数
     2) 查找单链表中的倒数第k个结点
     3) 单链表的反转（重点）
     4) 从尾到头打印单链表
     5) 合并两个有序的单链表，合并之后的链表依然有序

     */

    //求链表中的有效节点的个数
    //1.判断非空
    //2.遍历，计数加加,不计头节点
    public static int getSize(){
        int size = 0;
        HeroLink temp = head.next;
        if(temp==null){
            return 0;
        }
        while(true){
            if(temp!=null){
                size++;
                temp = temp.next;
            }else{
                break;
            }
        }
        return size;
    }

    //输出倒数第k个节点上的数
    public static HeroLink findIndex(int i){
        //获取全部有效位数size
        //分情况套路
        //1.链表为空，则直接返回null
        //2.index是否有误
        //3.正常输出的情况，只要遍历到size-index的位置即可；

        HeroLink temp = head.next;
        int index = i;
        int size = SingLinkedList.getSize();
        if(temp==null){
            return null;
        }

        if(index<0||index>size){
            return null;
        }
        for(int i1 = 0;i1<size-index;i1++){
            temp = temp.next;
        }
        return temp;
    }

    //将链表转换成倒序
    //思路
    //1.分情况，如果为空、只有一个元素
    //2.其它：
    //另外创建一个头指针
    //这边每遍历（需要temp中间变量）一个，就插到新创建节点的头节点之后（插入）
    //当next为null时，遍历完毕，再把原来的头指针指向第一个元素
    public static void reverseLink(){
        HeroLink cur = null;
        HeroLink reverse = new HeroLink(0,"","");
        HeroLink temp = head.next;
        if(temp.next==null||temp.next.next==null){
            return ;
        }
        while(temp!= null){
            //把temp取出来插进去，那它原来后面的怎么办？再加一个节点
            cur = temp.next;
            temp.next = reverse.next;
            reverse.next = temp;
            temp = cur;//继续回到原来链表的位置去操作
        }
        head.next = reverse.next;
        SingLinkedList.list();
    }

    //实现链表的倒序输出，需要注意，这里不能改变原来链表，引入栈Stack
    //思路，遍历链表，压入堆栈，弹出输出
    public static void reverseOutput(){
        Stack<HeroLink> s = new Stack<>();
        HeroLink temp = head.next;
        if(temp ==null){
            return;
        }
        while(temp!=null){
            s.push(temp);
            temp = temp.next;
        }

        for(int i=0;i<SingLinkedList.getSize();i++){
            System.out.println(s.pop());
        }
    }


}

class HeroLink{
    private int number;
    private String name;
    private String nikename;
    public HeroLink next;//头指针初始值为null

    public HeroLink(int number, String name, String nikename) {
        this.number = number;
        this.name = name;
        this.nikename = nikename;
    }

    @Override
    public String toString() {
        return "SingLinkedList{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", nikename='" + nikename + '\'' +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }
}
