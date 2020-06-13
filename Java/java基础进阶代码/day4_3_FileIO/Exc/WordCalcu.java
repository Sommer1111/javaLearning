package day4_3_FileIO.Exc;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Auther:sommer1111
 * @date 2020/4/10 15:39
 */
public class WordCalcu {
    // 获取文本上每个字符出现的次数
    // 提示：创建Map，获取字符文本，遍历文本的每一个字符；字符及出现的次数保存在Map中；
    // 将Map中数据写入文件

    public static void main(String[] args) {
        FileReader fr = null;
        BufferedWriter fw = null;

        try {
            //1.确定文本
            File f1 = new File("hello.txt");
            FileWriter f2 = new FileWriter("calcu.txt");

            fr = new FileReader(f1);
            fw= new BufferedWriter(f2);

            HashMap<Character,Integer> map = new HashMap<>();

            //2.遍历文本字符，将字符作为键值，次数作为value存放在map中
            int len;
            int count=1;
            while((len = fr.read() )!=-1){

                //注意一个强转的意义，当不是末尾的时候返回的实际是每一个字符
                char ch = (char)len;
                if(map.get(ch) == null){
                    map.put(ch,1);
                }else{
                    map.put(ch,map.get(ch)+1);
                }

            }

            //3.将map写入————>如何写？
            //遍历map出entry数组，getKey+getValue存取
            Set<Map.Entry<Character, Integer>> entry = map.entrySet();
           for(Map.Entry<Character, Integer> ent:entry){
               //注意只有拿出单个的·entry才有getKey方法

               //这里可以用switch 分情况判断空格、换行号等其它情况
               fw.write(ent.getKey()+"====="+ent.getValue());
               //加入一行换行
               fw.newLine();
           }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        //4.关闭流
        if(fr != null){
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(fw != null){
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
