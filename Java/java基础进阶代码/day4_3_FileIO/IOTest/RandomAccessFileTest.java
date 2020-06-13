package day4_3_FileIO.IOTest;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Auther:sommer1111
 * @date 2020/4/10 9:50
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
        RandomAccessFile r1 = null;
        RandomAccessFile r2 = null;

        try {
            //1.指明读入的文件，只读
            r1 = new RandomAccessFile(new File("2.jpg"),"r");
            //2.指明写出的文件,指定模式可读可写
            r2 = new RandomAccessFile(new File("2-222.jpg"),"rw");

            //3.复制
            byte[] b = new byte[10];
            int len;

            while((len = r1.read(b) )!=-1){
                r2.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        if(r2 !=null){
            try {
                r2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(r1 !=null){
            try {
                r1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
