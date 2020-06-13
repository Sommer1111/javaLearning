package day4_1_shape.test1_employee;

/**
 * @Auther:sommer1111
 * @date 2020/4/3 10:10
 */
public class Employee implements Comparable{
    private String name;
    private int age;
    private MyDate mybirthday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate mybirthday) {
        this.name = name;
        this.age = age;
        this.mybirthday = mybirthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getMybirthday() {
        return mybirthday;
    }

    public void setMybirthday(MyDate mybirthday) {
        this.mybirthday = mybirthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", mybirthday=" + mybirthday +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee){
            Employee e = (Employee)o;
            return this.name.compareTo(e.name);

        }else{
            throw new RuntimeException("输入数据有误");
        }
    }
}
