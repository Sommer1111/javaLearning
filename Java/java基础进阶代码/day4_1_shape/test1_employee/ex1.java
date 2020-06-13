package day4_1_shape.test1_employee;

/**
 * @Auther:sommer1111
 * @date 2020/4/2 11:16
 */


import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 定义一个 Employee 类，
 * 该类包含：private 成员变量 name,age,birthday，其中 birthday 为 MyDate 类的对象；
 * 并为每一个属性定义 getter, setter 方法； 并重写 toString 方法输出 name, age, birthday
 * MyDate 类包含: private 成员变量 month,day,year；
 * 并为每一个属性定义 getter, setter 方法；
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（TreeSet 需使用泛型 来定义）， 分
 * 别按以下两种方式对集合中的元素进行排序，并遍历输出：
 * 1). 使 Employee 继承 Comparable 接口，并按 name 排序
 * 2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序。
 */
public class ex1{
    public static void main(String[] args) {

        //1.创建TreeSet以默认排序方式存储数据
        TreeSet<Employee> set = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee t1, Employee t2) {
                MyDate b1 = t1.getMybirthday();
                MyDate b2 = t2.getMybirthday();

                //跳转MyDate必须实现Comparable接口
                return b1.compareTo(b2);
            }
        });

        //2.创建该类的5个对象
        //先创建5个生日对象
        MyDate myDate1 = new MyDate(1998,2,20);
        MyDate myDate2 = new MyDate(2001, 10, 13);
        MyDate myDate3 = new MyDate(1988, 3, 25);
        MyDate myDate4 = new MyDate(1993, 4, 24);
        MyDate myDate5 = new MyDate(1997, 12, 1);

        //再创建雇员对象
        Employee employee = new Employee("jeck", 32, myDate1);
        Employee employee1 = new Employee("Dim", 21, myDate2);
        Employee employee2 = new Employee("Tina", 18, myDate3);
        Employee employee3 = new Employee("Sim", 24, myDate4);
        Employee employee4 = new Employee("pi", 28, myDate5);

        //3.将对象加入treeSet里面
        set.add(employee);
        set.add(employee1);
        set.add(employee2);
        set.add(employee3);
        set.add(employee4);

        //4.遍历输出所有雇员信息
        Iterator<Employee> iterator = set.iterator();
        while(iterator.hasNext()){
            Employee t = iterator.next();
            System.out.println(t);
        }

    }
}