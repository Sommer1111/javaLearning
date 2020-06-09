package cn.code.day4_1_shape.wordTest;

/**
 * @Auther:sommer1111
 * @date 2020/4/3 14:41
 */
public class AppleTest {
    public static void main(String[] args) {
        Apple<String> a1=new Apple<>("500克");
        Apple<Integer> a2 = new Apple<>(500);
        Apple<Double> a3 = new Apple<>(500.0);

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }
}
