package cn.code.day4_12_communicate;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Auther:sommer1111
 * @date 2020/4/15 11:39
 */
public class UDPTest_receive {
    public static void main(String[] args){
        //这是接受端
        DatagramSocket socket = null;

        try {
            //1.创建套接字，建立通路,接受方必须指明自己的地址,搭在我这个地方
            socket = new DatagramSocket(8080);

            //2.接受数据，将数据打包存储
            byte[] b = new byte[100];
            DatagramPacket re = new DatagramPacket(b,0,b.length);
            socket.receive(re);//从这个套接字接受数据，将数据返回到re的缓冲区

            //3.显示数据
            System.out.println(new String(re.getData(),0,re.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭数据
            if(socket != null){
                socket.close();
            }

        }
    }
}
