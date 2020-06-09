package cn.code.day4_3_FileIO.Exc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Auther:sommer1111
 * @date 2020/4/10 10:53
 */
public class JPGsafe {

    public static void main(String[] args) {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            //实现图片加密操作
            //写入的时候稍微变换一下，不是直接写入，再下次读取时，先处理再写入
            File f1 = new File("IMG_7382.JPG");
            File f2 = new File("IMG_7382-safe.JPG");

            fi = new FileInputStream(f1);
            fo = new FileOutputStream(f2);

            byte[] b = new byte[5];

            int len;
            while((len = fi.read(b)) != -1){
                for (int i = 0; i <len; i++) {
                    b[i] = (byte)(b[i] ^ 2);
                }
                fo.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        if(fi !=null ){
            try {
                fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(fo != null){
            try {
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //读取加密的图片
        FileInputStream fi2 = null;
        FileOutputStream fo2 = null;
        try {
            //实现图片加密操作
            //写入的时候稍微变换一下，不是直接写入，再下次读取时，先处理再写入
            File f3 = new File("IMG_7382-safe.JPG");
            File f4 = new File("IMG_7382-unload.JPG");

            fi = new FileInputStream(f3);
            fo = new FileOutputStream(f4);

            byte[] b = new byte[5];

            //我这里复制了三遍，所以实际每串字符都有三个，要三个读一次
            int len;

            while((len = fi.read(b)) != -1){
                //进行一个异或的操作，实现加密
                for (int i = 0; i <len; i++) {
                    //因为b是一个字节数组，每一个都要经过处理
                    b[i] = (byte)(b[i] ^ 2);

                }
                fo.write(b);



            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        if(fi !=null ){
            try {
                fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(fo != null){
            try {
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
