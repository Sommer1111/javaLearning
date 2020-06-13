package day4_1_shape;

import java.util.*;

/**
 * @Auther:sommer1111
 * @date 2020/4/1 10:32
 */
public class ShapeTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(23);
        arrayList.add(34);
        arrayList.add("terry");

        for(Object b:arrayList){
            System.out.println(b);
        }

        HashMap<String, Integer> hashMap = new HashMap<String,Integer>();
        hashMap.put("tom",32);
        hashMap.put("jerry",22);
        hashMap.put("xiaomi",12);

        Set<Map.Entry<String, Integer>> set = hashMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key+value);
        }

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<?> list3 = new ArrayList<>();
          list3=list1;
          list3 = list1;
    }
}
