package cn.code.day4_12_communicate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Auther:sommer1111
 * @date 2020/4/15 17:17
 */
public class URLTest {
    //URL：统一资源定位符，它表示 Internet 上某一 资源的地址。
    //构成：https://www.bilibili.com/video/BV1Kb411W75N?p=631
    //     通信协议+主机名（域名、IP）+资源地址+参数列表（多，比如视频定位、小说定位）

    public static void main(String[] args) {
        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream f = null;
        try {
            //1.创建URL资源链接
            URL url = new URL("https://www.bilibili.com/video/BV1Kb411W75N?p=631");

            //2.创建连接通路，类似于scoket
            urlConnection = (HttpURLConnection) url.openConnection();

            //3.连接资源，Connection对象获取的输入流和输出流
            urlConnection.connect();
            is = urlConnection.getInputStream();

            //4.接下来就是接收文件写入的问题啦
            f = new FileOutputStream("bilibili_mv");
            byte[] b = new byte[1024];
            int len;
            while((len = is.read(b)) != -1){
                f.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭连接
            if(f != null){
                try {
                    f.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(is!= null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(urlConnection !=null){
                urlConnection.disconnect();
            }
        }


    }

}
