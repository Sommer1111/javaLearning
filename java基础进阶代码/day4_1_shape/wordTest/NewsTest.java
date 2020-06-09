package cn.code.day4_1_shape.wordTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:sommer1111
 * @date 2020/4/3 14:48
 */

//在测试类中创建一个只能容纳该类对象的ArrayList集合
// 添加三条新闻。
// 遍历集合，打印新闻标题，将新闻标题截取字符串到10个汉字的长度
public class NewsTest {
    public static void main(String[] args) {
        List<News> list = new ArrayList<>();
        list.add(new News("The life of Pi","LIAn","A"));
        list.add(new News("据报道新的一年即将面临重大挑战","Make","B"));
        list.add(new News("人的力量源自于深邃的思想","L","C"));
        //System.out.println(list.get(1));

        for (int i = 0; i < list.size(); i++) {
            String title = list.get(i).getTitle();
            if(title.length()>10){
                String s = title.substring(0, 10);
                System.out.println(s);
            }else{
                System.out.println(title);
            }

        }
    }
}
