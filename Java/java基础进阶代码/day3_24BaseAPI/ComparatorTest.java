package day3_24BaseAPI;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        Goods[] goods = new Goods[5];
        goods[0] = new Goods("xiaomi",123);
        goods[1] = new Goods("logitech",99);
        goods[2] = new Goods("huawei",199);
        goods[3] = new Goods("vivo",145);
        goods[4] = new Goods("tianxia",126);

        Arrays.sort(goods,new Comparator(){
            //调用方法，重写compare，内部思想一致。
            @Override
            public int compare(Object o, Object t1) {
                if(o instanceof Goods){
                    Goods goods1 = (Goods)o;
                    Goods goods2 = (Goods)t1;
                    return goods1.compareTo(goods2);
                }
                throw new RuntimeException("输入数据非法！");
            }
        });
        System.out.println(Arrays.toString(goods));

    }
}
