package cn.code.day4_3_FileIO.IOTest;

import java.io.Serializable;

/**
 * @Auther:sommer1111
 * @date 2020/4/9 20:52
 */

public class Person implements Serializable {

    //自定义的类必须实现Serializable 相当于一个可序列化的标识
    //方法里面的所有都需要实现Serializable
    //必须要有序列号，表示序列化版本标识符，即便该类变量发生了改变，仍旧可以认出它

    private static final long serialVersionUID = 49794470754667710L;
    private String name;
    private int age;
    private Price pri;

    public Person() {
    }

    public Person(String name, int age, Price pri) {
        this.name = name;
        this.age = age;
        this.pri = pri;
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

    public Price getPri() {
        return pri;
    }

    public void setPri(Price pri) {
        this.pri = pri;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pri=" + pri +
                '}';
    }
}

class Price implements Serializable{
    private static final long serialVersionUID = 794470754667710L;
    private int income;

    public Price() {
    }

    public Price(int income) {
        this.income = income;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "Price{" +
                "income=" + income +
                '}';
    }
}
