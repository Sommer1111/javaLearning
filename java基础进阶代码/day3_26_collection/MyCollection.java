package cn.code.day3_26_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class MyCollection {
    public static void main(String[] args) {
        Collection col = new ArrayList();

        //增
        col.add(123);
        col.add("def");
        col.add(new Date());

        System.out.println("********************");

        //迭代器Iterator遍历集合元素
        Iterator iterator1 = col.iterator();
        while(iterator1.hasNext()){
            Object obj = iterator1.next();
            if(obj.equals("def")){
                iterator1.remove();
            }
        }

        Iterator iterator2 = col.iterator();
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

        System.out.println("-----------------------------");
        for(Object obj:col){
            System.out.println(obj);
        }




    }
}
