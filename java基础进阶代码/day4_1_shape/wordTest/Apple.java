package cn.code.day4_1_shape.wordTest;

/**
 * @Auther:sommer1111
 * @date 2020/4/3 14:37
 */

/**开发一个泛型Apple类
 * 要求有一个重量属性weight在测试类中实例化不同的泛型对象，
 * 要求对象a1的这一属性是String类型，
 * 对象a2的这一属性是Integer型，
 * a3的这一属性是Double型。
 * 分别为a1，a2，a3的重量属性赋值为：”500克”，500,500.0，
 * 在测试类中通过对象调用访问器得到属性值并输出。
 * */
public class Apple<T> {
    T weight;

    public Apple() {
    }

    public Apple(T weight) {
        this.weight = weight;
    }

    public T getWeight() {
        return weight;
    }

    public void setWeight(T weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}
