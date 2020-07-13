package DataStructureTest.HashTab;

import java.util.Scanner;

/**
 * 哈希表：
 *   它通过把关键码值映射到表中一个位置来访问记录，可以直接跳过遍历的环节，直接定位，可以加快查找的速度。
 *   这个映射函数叫做散列函数，存放记录的数组叫做散列表（数组+链表，或者也可以数组 +红黑树）
 *
 * 实现：
 *   有一个公司,当有新的员工来报道时,要求将该员工的信息加入记录(id,姓名),
 *   当输入该员工的id时,要求查找到该员工的所有信息.实现简单的增删查找功能
 *
 *   分析：
 *   1.Employee类，记录职工信息
 *   2.EmpLinkedList类，每一个数组位置的链表结构
 *   3.EmpHashTab类，将存储记录的数组组织起来。
 *
 * @Auther:sommer1111
 * @date 2020/7/13 10:33
 */
public class HashTab {
    public static void main(String[] args) {
        EmpHahTab hashtab = new EmpHahTab(10);
        //先前将这句写到while循环里面去了，list的时候一直全部是空的。head==null
        while(true){
            System.out.println("add:增加雇员信息");
            System.out.println("list:列表雇员信息");
            System.out.println("exit:退出系统");

            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            switch(next){
                case"add" :
                    System.out.println("请输入雇员信息：");
                    System.out.println("雇员id：");
                    int id = new Scanner(System.in).nextInt();
                    System.out.println("雇员姓名：");
                    String s = new Scanner(System.in).next();
                    Employee emp = new Employee(id,s);
                    hashtab.add(emp);
                    break;

                case"list" :
                    hashtab.list();
                    break;
                case"exit" :
                    scanner.close();
                    System.exit(0);
            }

        }
    }
}

class Employee{
    public int id;
    public String name;
    public Employee next;//实现链表，指向下一个链表上的员工

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList{//在某个位置上进行增删查改，操作这条链表
    private Employee  head;//创建头指针，默认为null

    //add 增加成员
    public void add(Employee emp){
        if(head==null){//我写成了head.next，但是此时head是默认的null,出现空指针异常
            head = emp;
        }else{
            Employee temp = head;//这里我写的时候head.next，应该会落一个。
            while(true){//找到链表的队尾
                if(temp.next ==null){
                    break;
                }
                temp = temp.next;
            }
            temp.next = emp;//加到队尾
        }

    }

    //列表成员
    public void list(){
        if(head ==null){
            System.out.println("链表为空！");
        }else{
            Employee temp = head;
            while(true){
                System.out.print("====>"+temp.id+" "+temp.name);
                if(temp.next ==null){
                    break;
                }
                temp = temp.next;

            }
            System.out.println();
        }
    }
}

class EmpHahTab{//组织其整张表
    private EmpLinkedList[] hashtab;//创建出这个链表数组
    private int size;

    public EmpHahTab( int size) {
        this.size = size;
        hashtab = new EmpLinkedList[size];//这里只是创建了这么多个位置。
        for (int i = 0; i < size; i++) {
            hashtab[i] = new EmpLinkedList();//具体每一个位置的链表又要初始化
        }
    }

    //散列函数:先确定添加的位置
    public int hashlocaion(int id){
        return id % size;

    }
    //具体组织添加add
    public void add(Employee emp){
        int loc  = hashlocaion(emp.id);
        hashtab[loc].add(emp);
    }

    //具体组织列表list
    public void list(){
        for (int i = 0; i < size; i++) {
            System.out.print("第"+i+"处");
            hashtab[i].list();
    }
    }
}
