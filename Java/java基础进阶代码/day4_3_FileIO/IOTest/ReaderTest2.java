package day4_3_FileIO.IOTest;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Auther:sommer1111
 * @date 2020/4/4 16:50
 */
public class ReaderTest2 {
    public static void main(String[] args) throws IOException {
        //声明个引用，因为这个new对象的时候也是会异常的
        FileReader reader = null;
        try {
            //1.新建处理的文件对象，相较于当前工程位置
            File file = new File("sommer\\src\\cn\\code\\day4_3_File\\IOTest\\hello.txt");
            //2.新建流
            reader = new FileReader(file);

            //3.read()读入带参操作，用字符串接收
            char[] ch = new char[5];
            //每次返回字符串，容器多大返回几个
            int i = reader.read(ch);


            //4.遍历输出
            while(i !=-1){
                    String str = new String(ch,0,i);
                    System.out.print(str);
                    i = reader.read(ch);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭流
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        //文件不存在则自动创建
        File f = new File("hello2.txt");
        FileWriter w = new FileWriter(f);
        w.write("hello world\n");
        w.write("hello my dear".toString());
        //运行多次则默认覆盖
        //需要补充到后面则w.write("hello world\n",false);
        w.close();

        FileReader readtest = null;
        FileWriter writertest = null;

        try {
            //读进来写出去
            //1.文件
            File file1 = new File("hello.txt");
            File file2 = new File("hello2.txt");

            //2.创建流
            readtest = new FileReader(file1);
            writertest = new FileWriter(file2,false);

            //3.读入操作
            char[] ch = new char[3];

            int len = readtest.read(ch);
            while(len != -1){
                writertest.write(ch,0,len);
                len = readtest.read(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writertest != null){
                try {
                    writertest.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(readtest != null){
                try {
                    readtest.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }







    }
}
