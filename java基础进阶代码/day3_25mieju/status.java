package cn.code.day3_25mieju;

public class status {
    public static void main(String[] args) {
        Fruits apple1 = Fruits.APPLE;
        System.out.println(apple1);


    }
}

class Fruits{
    private final String name;
    private final int price;

    private Fruits(String name, int price) {
        this.name = name;
        this.price = price;
    }

    //赋值
    public static final Fruits APPLE = new Fruits("apple",3);
    public static final Fruits PINK = new Fruits("pink",5);
    public static final Fruits WATER = new Fruits("water",1);

    @Override
    public String toString() {
        return "我超喜欢吃" +
                "name='" + name + '\'' +
                ", price=" + price +
                "这种水果，你喜欢什么？";
    }
}