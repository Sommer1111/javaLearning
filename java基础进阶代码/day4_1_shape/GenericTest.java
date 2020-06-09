package cn.code.day4_1_shape;



import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:sommer1111
 * @date 2020/4/1 16:39
 */
public class GenericTest {

    public static void main(String[] args) {
        Test<Integer> t = new Test<Integer>();
        System.out.println(t);

        //调用泛型方法时
        Integer[] i = new Integer[]{1,2,3,4};
        List<Integer> copy = t.copy(i);
        System.out.println(copy);


    }


}

//自定义泛型类
class Test<T>{
    String s1;
    T s;

    public Test() {
    }

    public Test(String s1, T s) {
        this.s1 = s1;
        this.s = s;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public T getS() {
        return s;
    }

    public void setS(T s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "Test{" +
                "s1='" + s1 + '\'' +
                ", s=" + s +
                '}';
    }

    public void teat(){
        //T[] ts = new T[10];
        T[] ts1 = (T[]) new Object[10];
    }

    //自定义泛型方法：
    //定义：泛型方法标识符<E>+返回的类型 + 方法名（变量类型 变量名）
    //方法体内要实现什么操作
    public <E> List<E> copy(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for(E e:arr){
            list.add(e);
        }
        return list;
    }
}
