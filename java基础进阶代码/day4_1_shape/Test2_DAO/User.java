package cn.code.day4_1_shape.Test2_DAO;

/**
 * @Auther:sommer1111
 * @date 2020/4/3 10:52
 */
public class User {
    //定义一个 User 类：
    // 该类包含：private 成员变量（int 类型） id，age；（ String 类型）name。

    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
