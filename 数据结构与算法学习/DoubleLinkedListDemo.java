package DataStructureTest;

/**
 * 在单项链表的基础之上实现双向链表
 * @Auther:sommer1111
 * @date 2020/5/29 18:37
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroLink2 hero1 = new HeroLink2(1,"白起","战神");
        HeroLink2 hero2 = new HeroLink2(2,"商鞅","立法");
        HeroLink2 hero3 = new HeroLink2(3,"赢渠梁","明君");
        HeroLink2 hero4 = new HeroLink2(4,"李白","诗仙");
        HeroLink2 hero5 = new HeroLink2(5,"辛弃疾","爱国");

        DoubleLinkedList d = new DoubleLinkedList();
        d.add2(hero1);
        d.add2(hero5);
        d.add2(hero3);
        d.add2(hero2);
        d.add2(hero4);
        d.del(5);

        d.list();
    }

}

class DoubleLinkedList{
    //创建一个头指针
    static HeroLink2 head = new HeroLink2(0,"","");
    //创建中间变量

    //双向链表的添加，直接加到最后的位置
    public static void add(HeroLink2 hero){
       HeroLink2 temp = head;

       //找到最后一个位置
       while(temp.next!=null){
           temp = temp.next;
       }
       //进行添加操作
       temp.next  = hero;
       hero.pre = temp;
    }

    //实现双向链表的按编号顺序来添加
    //思路：找位置 + 再添加
    //1.如果为空直接添加
    //2.其它情况：获取编号，遍历链表，找到后一个编号比他它的位置
    public static void add2(HeroLink2 hero){
        HeroLink2 temp = head;
        //找位置
        while(true){
            if(temp.next ==null){
                break;
            }
            if(temp.next.getNumber()>hero.getNumber()){
                break;
            }
            temp = temp.next;
        }
        //操作,注意，如果是空指针的话，没有temp.next.pre报错空指针异常
        if(temp.next!=null){
            temp.next.pre = hero;
            hero.next = temp.next;
        }
        temp.next = hero;
        hero.pre = temp;
    }

    //双向链表的删除操作
    //思路：找位置+操作
    //1.如果为空的话，提示
    //2.其它情况遍历所有的节点直到找到符合的节点

    public static void del(int index){
        HeroLink2 temp = head;
        //找位置:temp
        if(temp.next==null){
            System.out.println("链表为空，无法删除~");
        }
        while(true){
            if(temp.getNumber()==index){
                break;
            }
            temp =temp.next;
        }
        //操作:也要注意刚好最后一个位置空指针异常的情况
        if(temp.next!=null){
            temp.next.pre = temp.pre;
        }
        temp.pre.next = temp.next;
    }

    //实现列表
    public static void list(){
        HeroLink2 temp = head.next;
        if(temp==null){
            return;
        }
        while(temp!=null){
            System.out.println(temp);
            temp = temp.next;
        }
    }


}

class HeroLink2{
    private int number;
    private String name;
    private String nikename;
    public HeroLink2 next;//头指针初始值为null
    public HeroLink2 pre;//增加一个往前的指针

    public HeroLink2(int number, String name, String nikename) {
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
