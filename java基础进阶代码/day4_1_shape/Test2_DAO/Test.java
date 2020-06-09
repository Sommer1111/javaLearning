package cn.code.day4_1_shape.Test2_DAO;

import java.util.List;

/**
 * @Auther:sommer1111
 * @date 2020/4/3 10:54
 */
public class Test {
    public static void main(String[] args) {
        //定义一个测试类：
        // 创建 DAO 类的对象，
        // 分别调用其 save、get、update、list、delete 方 法来操作 User 对象，


        //实例化对象
        DAO<User> d = new DAO<User>();
        User u1 = new User(1, "Tom");
        User u2 = new User(2, "Jeck");
        User u3 = new User(3, "Merry");

        d.save("A", u1);
        d.save("B", u2);
        d.save("c", u3);

        List<User> list1 = d.list();
        System.out.println("这是list方法的输出" + list1);

        d.update("A", u3);
        List<User> list2 = d.list();
        System.out.println("这是update方法的输出" + list2);

        Object a = d.get("A");
        System.out.println("这是get方法的输出" + a);

        d.delete("A");
        list2.forEach(System.out::println);
    }
}