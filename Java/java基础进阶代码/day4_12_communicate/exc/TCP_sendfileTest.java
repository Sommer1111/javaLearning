package day4_12_communicate.exc;

import java.io.*;
import java.net.Socket;

/**
 * @Auther:sommer1111
 * @date 2020/4/16 9:40
 */
public class TCP_sendfileTest {
    //客户端发送文件给服务端，服务端将文件保存在本地,并返回“发送成功”给客户端
    //分析：文件，要用到字节输入输出流FileInputStream、FileOutputStream
    //创建客户端、服务端
    public static void main(String[] args)  {
        Socket s1 = null;
        OutputStream os = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            //1.创建你套接字，建立通路
            s1 = new Socket("127.0.0.1",8088);
            //2.获取输出流，用于输出数据
            os = s1.getOutputStream();

            //创建要发送的文件
            File file1 = new File("hello.txt");
            FileInputStream fos = new FileInputStream(file1);
            byte[] b = new byte[1024];
            int len;
            while((len = fos.read(b)) != -1){
                os.write(b,0,len);
            }
            s1.shutdownOutput();

            //客户端接收反馈信息，显示出来
            is = s1.getInputStream();
            byte[] b1 = new byte[1024];
            baos = new ByteArrayOutputStream();
            int len1;
            while((len1 = is.read(b1)) != -1){
                baos.write(b1,0,len1);
            }
            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭流
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(s1 != null){
                try {
                    s1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if(is !=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }





    }
}
