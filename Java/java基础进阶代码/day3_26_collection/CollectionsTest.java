package day3_26_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(123);
        list.add("1234");
        list.add(546);
        list.add("789");
        list.add(98);


        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);
        System.out.println(list);
    }
}
