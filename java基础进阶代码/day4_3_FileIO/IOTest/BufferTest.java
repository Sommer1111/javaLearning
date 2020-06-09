package cn.code.day4_3_FileIO.IOTest;

import java.io.*;

/**
 * @Auther:sommer1111
 * @date 2020/4/9 10:16
 */

/**
 * BUffered 缓冲流提供了一个缓冲区，读的内容积攒到一定程度之后再写可以提高效率
 */
public class BufferTest {
    public static void main(String[] args) {
        BufferedInputStream b1 = null;
        BufferedOutputStream b2 = null;

        try {
            //1.创建文件
            File f1 = new File("2.jpg");
            File f2 = new File("2-2.jpg");
            //2.创建流
            //2.1创建节点流
            FileInputStream fin1 = new FileInputStream(f1);
            FileOutputStream fout2 = new FileOutputStream(f2);

            //2.2创建处理流
            b1 = new BufferedInputStream(fin1);
            b2 = new BufferedOutputStream(fout2);

            //3.操作，读取，写入
            byte[] by = new byte[5];
            int len;
            while((len = b1.read(by)) !=-1){
                b2.write(by,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            if(b2 !=null){
                try {
                    b2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(b1 !=null){
                try {
                    b1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }



    }
}
