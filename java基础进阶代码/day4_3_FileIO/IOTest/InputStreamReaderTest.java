package cn.code.day4_3_FileIO.IOTest;

import java.io.*;

/**
 * @Auther:sommer1111
 * @date 2020/4/9 11:13
 */
//实现字节输入————>字符输入

public class InputStreamReaderTest {


    public static void main(String[] args) {
        InputStreamReader isr = null;
        OutputStreamWriterTest osw = null;
        try {
            //1.创建流
            FileInputStream f1 = new FileInputStream("dbcp.txt");
            //FileOutputStream f2 = new FileOutputStream("dbcp_gbk.txt");

            //2.创建转换流,默认是UTF-8格式，也可以自己另外设置
            isr = new InputStreamReader(f1,"gbk");
            //osw = new OutputStreamWriter(f2);

            //3.读取、写入具体操作
            char[] ch = new char[10];
            int len;
            while((len = isr.read(ch)) !=-1){
                String s = new String(ch,0,len);
                System.out.print(s);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        //4.关闭流
        if(isr != null){
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
