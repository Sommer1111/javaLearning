package day4_12_communicate;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Auther:sommer1111
 * @date 2020/4/15 11:17
 */
public class UDPTest_send {
    //一样分为客户端、接受端，只是用数据报把数据封装初步处理了一下。
    //类 DatagramSocket：创建数据报套接字，在客户端与服务端之间建立发送通路
    //类 DatagramPacket：打包数据成数据报，（打包快递）

    public static void main(String[] args) {

        // DatagramSocket指定自己的端口号，如果没有指定，则系统默认分配，
        // DatagramPacket指定接收对方的端口号
        DatagramSocket socket = null;

        try {
            //客户端
            //1.创建套接字,建立连接通路
            socket = new DatagramSocket();

            //2.处理要发送的数据
            String s = new String("我是UDP的数据传输的测试语句");
            byte[] data = s.getBytes();
            InetAddress inet = InetAddress.getByName("127.0.0.1");

            //3.把数据打包,指明对方的地址（IP、端口号）————>快递发送出去
            DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,8080);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            if(socket != null){
                System.out.println("快递已发出，注意查收");
                socket.close();
            }
        }

    }


}
