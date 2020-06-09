package cn.code.day4_3_FileIO.IOTest;

import java.io.*;

/**
 * @Auther:sommer1111
 * @date 2020/4/8 16:06
 */
public class FileInputStreamTest {
    public static void main(String[] args) {
        String src ="2.jpg";
        String des = "3-1.jpg";
        long strat = System.currentTimeMillis();
        copymv(src,des);
        long end = System.currentTimeMillis();
        System.out.println("复制花了"+(end-strat)+"毫秒");
    }

    //写成一个函数方法
    public static void copymv(String src,String des){
        FileInputStream fin = null;
        FileOutputStream fou = null;
        try {
            //1.创建文件
            File fi = new File(src);
            File fo = new File(des);

            //2.创建流
            fin = new FileInputStream(fi);
            fou = new FileOutputStream(fo);

            //3.写入
            //里面没有元素；但是你i尝试取第一个元素，所以导致越界
            byte[] by= new byte[5];
            int len;
            //这里写成！=0了，报错OutOfBoundsException 找了半天！注意啊啊啊
            while((len = fin.read(by)) !=-1){
                fou.write(by,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流

            try {
                if(fin != null) {
                    fin.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }



            try {
                if(fou != null) {
                    fou.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
