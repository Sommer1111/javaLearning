package cn.code.day3_24BaseAPI;

import java.util.Arrays;

public class ComparableTest {
    //举例试用数组之间的比较
    //1.列举出商品信息，需要额外定义一个类（需要具备所以体系），重写CompareTo方法
    //2.生成具体的对象
    //3.可以直接调用String、包装类方法比较，因为这些方法已经实现了ComparableTo的重写
    public static void main(String[] args) {

        //生成模拟的产品比较信息
        Goods[] goods = new Goods[5];
        goods[0] = new Goods("xiaomi",123);
        goods[1] = new Goods("logitech",99);
        goods[2] = new Goods("huawei",199);
        goods[3] = new Goods("vivo",145);
        goods[4] = new Goods("tianxia",126);

        //比较
        Arrays.sort(goods);
        //因为Arrays.sort这个方法里面只需要放入Object类型的数据即可所以这里可以把goods放进去
        // 可以这样理解，sort没有返回值，所以这里goods已经发生了改变，可以直接打印
        System.out.println(Arrays.toString(goods));
        //Arrays.toString的作用是输出一个数组的字符串形式



    }
}



class Goods implements Comparable{
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    //compareTo实际作用是把原本无法比较的对象转化成可以比较的整数对象
    // 然后其它排序的方法就可以对此排序

    //两个对象即通过 compareTo(Object obj) 方法的返回值来比较大小
    //定义:比较此对象与指定对象的顺序。
    //返回:负整数、零或正整数。如果该对象小于、等于或大于指定对象，则分别返回负整数、零或正整数。
    public int compareTo(Object o) {
       if(o instanceof Goods){
          Goods goods = (Goods)o;
          if(goods.price>this.price){
              return 1;
          }else if(goods.price<this.price){
              return -1;
          }else{
              return goods.name.compareTo(this.name);
          }

       }else{
          throw new RuntimeException("输入数据非法！");
       }
    }
}