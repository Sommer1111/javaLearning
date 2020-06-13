package day3_26_collection;



import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        Set set = new TreeSet();
        set.add(new Person2("Mary",31));
        set.add(new Person2("jack",20));
        set.add(new Person2("jerry",10));

        for(Object b:set){
            System.out.println(b);
            }

        System.out.println("***********");
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());


        }

        System.out.println("--------------");

        HashMap map = new HashMap();
        map.put(123,"xioaomi");
        map.clear();
        System.out.println(map);
    }
}
