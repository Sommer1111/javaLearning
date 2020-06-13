package day4_12_communicate;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Auther:sommer1111
 * @date 2020/4/12 13:49
 */
public class comTest {
    public static void main(String[] args) throws IOException {
        try {
            //1.实例化对象的方法，可以传入IP地址，也可以传入域名
            InetAddress inet1 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet1);
            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);
            InetAddress inet  = InetAddress.getLocalHost();
            System.out.println(inet);

            //2.获取域名和IP的方法
            System.out.println(inet2.getHostName());
            System.out.println(inet2.getHostAddress());

            //3.有关套接字的使用
            //创建一个流套接字并将其连接到指定IP 地址的指定端口号。
            Socket s = new Socket("127.0.0.1",8808);

            //返回此套接字的输出流。可以用于发送消息
            OutputStream o = s.getOutputStream();

            //返回此套接字的输入流，用于接收消息
            InputStream inputStream = s.getInputStream();

            //获取对方的IP地址，如果未连接则返回null
            InetAddress inetAddress = s.getInetAddress();

            //获取自己的IP地址
            InetAddress localAddress = s.getLocalAddress();

            //获取对方连接的端口号，未连接则返回0
            //获取自己的端口号，未连接返回-1
            int port = s.getPort();
            int localPort = s.getLocalPort();

            //关闭输入输出
            s.shutdownInput();
            s.shutdownOutput();


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
