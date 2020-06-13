package day4_12_communicate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther:sommer1111
 * @date 2020/4/12 17:01
 */
public class Tcp2ServiceTest {
    public static void main(String[] args) {
        InputStream in = null;
        ByteArrayOutputStream bi= null;
        ServerSocket ss = null;
        Socket accept = null;
        try {
            //服务段
            //1.创建ServerSocket
           ss = new ServerSocket(8088);

            //2.调用accept()表示接收来自于客户端的socket
            accept = ss.accept();

            //3.输入流
            in = accept.getInputStream();
            bi = new ByteArrayOutputStream();

            //4.显示操作
            byte[] b = new byte[5];
            int len;
            //因为输入的是文本的话，裁剪可能会出现乱码，所以避免用老方法。这里使用新的ByteArrayOutputStrem
            //它的原理是收在自己身上，不写到其它的文件里，收完了一起转化。因为这里要显示，所以是output
            //输入流读取每一个字节
            //输出显示

            while((len = in.read(b)) != -1){
                bi.write(b,0,len);
            }
            System.out.println("建立连接"+bi.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {


            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bi != null) {
                try {
                    bi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
