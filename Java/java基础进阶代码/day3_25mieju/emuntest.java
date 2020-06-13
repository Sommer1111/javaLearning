package day3_25mieju;

import java.lang.annotation.Retention;

public class emuntest {
    public static void main(String[] args) {
        Fruits1 a = Fruits1.APPLE;
        System.out.println(a);
    }
}

@MyAnnotation("hi")
enum Fruits1{
    //1.首先设置
    APPLE("apple",3),
    PINK("pink",5),
    WATER("water",1);


    private final String name;
    private final int price;

    private Fruits1(String name, int price) {
        this.name = name;
        this.price = price;
    }

}

