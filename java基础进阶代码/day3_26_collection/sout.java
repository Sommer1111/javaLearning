package cn.code.day3_26_collection;

import java.util.*;

public class sout {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("A",133);
        map.put("C",321);
        map.put("V",567);
        System.out.println(map);

        HashMap map1 = new HashMap();
        map1.put("D",111);
        map1.put("E",222);
        map1.put("F",333);

        map.putAll(map1);
        System.out.println(map1);
        System.out.println(map);

        //遍历map的所有键值
        //因为键值实际上是Set
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("--------");

        Collection values = map.values();
        Iterator iterator1 = values.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

//        System.out.println("***************");
//        for(Object obj:values){
//            System.out.println(obj);
//
//        }

        //遍历输出entry
        System.out.println("%%%%%%%%%%%%%%%%%%");
        Set set1 = map.entrySet();
        Iterator iterator2 = set1.iterator();
        while(iterator2.hasNext()){
            //获取的entrySet里面的每一对数据都是一个entry
            //对里面的数据进行遍历，需要分别获取key和values
            //两层iterator
            Object o = iterator2.next();
            Map.Entry entry = (Map.Entry)o;
            System.out.println(entry.getKey()+"==="+entry.getValue());
        }


    }
}
