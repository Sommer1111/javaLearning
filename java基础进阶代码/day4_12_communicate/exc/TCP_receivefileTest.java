package cn.code.day4_12_communicate.exc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther:sommer1111
 * @date 2020/4/16 9:54
 */
public class TCP_receivefileTest {
    public static void main(String[] args) {
        ServerSocket s2 = null;
        Socket accept = null;
        InputStream is = null;
        FileOutputStream f = null;
        OutputStream os1 = null;
        try {
            //创建你套接字
            //获取输入流
            //创建FileOutputStream保存接收到的数据

            s2 = new ServerSocket(8088);
            accept = s2.accept();
            is = accept.getInputStream();

            f = new FileOutputStream("hello_TCP.txt");
            byte[] b2 = new byte[1024];
            int len;
            while((len=is.read(b2) )!= -1){
                f.write(b2,0,len);
            }
            System.out.println("文件传输完成");

            //并返回“发送成功”给 客户端
            os1= accept.getOutputStream();
            String string = new String("成功接受发送信息！");
            byte[] bytes = string.getBytes();
            os1.write(bytes);




        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(s2 != null){
                try {
                    s2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(f != null){
                try {
                    f.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(accept != null){
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(os1 != null){
                try {
                    os1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
