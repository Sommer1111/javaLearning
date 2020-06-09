package cn.code.day4_12_communicate;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther:sommer1111
 * @date 2020/4/12 15:16
 */
public class Tcp1clientTest {
    public static void main(String[] args) {

        //客户端发送信息给服务器，服务器显示在工作台上。
        //客户端实现
        //1.创建连接的套接字
        Socket s = null;
        OutputStream os = null;
        try {
            s = new Socket("127.0.0.1",8088);

            //2.获取输出流，用于写出数据
            os = s.getOutputStream();

            //3.写出数据的操作
            os.write("我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭套接字、输出流
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(s != null){
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
