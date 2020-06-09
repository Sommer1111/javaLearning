package cn.code.day4_3_FileIO.IOTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Auther:sommer1111
 * @date 2020/4/4 15:58
 */

//为什么不try-catch会报异常：
// 流传递过程还是挺脆弱的，复制一个文件，由于网络原因或者人为操作取消复制操作都会中断流的传递，
// 如果不捕获异常，Java 程序会报错进而直接中断程序的运行。
// Unhandled exception的原因
// 说明某个方法在方法声明上已经声明了会抛异常,
// 那么在调用这个方法的时候,就必须做异常处理
public class ReaderTest {
    public static void main(String[] args) {
        //声明个引用，因为这个new对象的时候也是会异常的
        FileReader reader = null;
        try {
            //1.新建处理的文件对象，相较于当前工程位置
            File file = new File("sommer\\src\\cn\\code\\day4_3_File\\IOTest\\hello.txt");
            //2.新建流
            reader = new FileReader(file);

            //3.read()读入操作，read()的意义是返回一个字符，如果到了文件结尾则返回-1
            int i = reader.read();

            //4.遍历输出
            while(i !=-1){
                //字符返回的是ASCII的整数，所以要想显示必须向下强转
                System.out.print((char)i);
                //类似于迭代器继续读
                i = reader.read();
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

    }
}
