package cn.code.day4_16_reflecttion;

/**
 * @Auther:sommer1111
 * @date 2020/4/17 16:30
 */
public class Person {
    public int age;
    private String name;
    private String country;

    public Person() {
    }

    public Person(int age, String name, String country) {
        this.age = age;
        this.name = name;
        this.country = country;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public void show(String name){
        this.name = name;
        System.out.println(name+",我是一个开心的小豆豆");
    }
}
