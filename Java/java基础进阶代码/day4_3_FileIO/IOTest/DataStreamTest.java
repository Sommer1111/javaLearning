package day4_3_FileIO.IOTest;

import java.io.*;

/**
 * @Auther:sommer1111
 * @date 2020/4/9 19:50
 */
public class DataStreamTest {
    public static void main(String[] args) {
        //测试将数据存储到文件，DataInputStream
        DataOutputStream das = null;

        try {
            //1.创建数据流（先创建文件节点流）
            das = new DataOutputStream(new FileOutputStream("data.txt"));

            //2.写入数据
            das.writeBoolean(true);
            das.flush();
            das.writeChar('a');
            das.flush();
            das.writeUTF("Hello!my world");
            das.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        //3.关闭流
        if(das != null){
            try {
                das.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //测试，从存取的文件中读取数据 DataInputStream
        //1.创建数据流
        DataInputStream dai = null;
        try {
            dai = new DataInputStream(new FileInputStream("data.txt"));

            //2.读取数据
            boolean b = dai.readBoolean();
            char c = dai.readChar();
            String s = dai.readUTF();

            System.out.println(b);
            System.out.println(c);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        //3.关闭流
        if(dai != null){
            try {
                dai.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
