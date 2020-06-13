package day4_3_FileIO.IOTest;

import java.io.*;

/**
 * @Auther:sommer1111
 * @date 2020/4/9 11:48
 */
public class OutputStreamWriterTest {
    //字符————>字节输出
    public static void main(String[] args) {
        //1.创建文件
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            File f1 = new File("dbcp.txt");
            File f2 = new File("dbcp_gbk.txt");

            //2.1创建流字节流
            FileInputStream fis = new FileInputStream(f1);
            FileOutputStream fos = new FileOutputStream(f2);


            //2.2创建转换流
            isr = new InputStreamReader(fis);
            osw = new OutputStreamWriter(fos,"UTF-8");

            //3.实现转换操作
            char[] ch = new char[5];
            int len;
            while ((len = isr.read(ch)) !=-1) {
                osw.write(ch,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(isr != null){
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            }

            if(osw != null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
