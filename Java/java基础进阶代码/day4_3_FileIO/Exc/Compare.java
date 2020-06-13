package day4_3_FileIO.Exc;

import java.io.*;

/**
 * @Auther:sommer1111
 * @date 2020/4/10 10:27
 */
public class Compare {
    public static void main(String[] args) {
        //比较节点流与缓冲流在复制视频的效率
        //1.FileInputStream、FileOutputStream，实现复制
        //2.BufferedInputStream、BufferedOutputStream，实现复制
        //3.分别获取时间
        FileInputStream fis= null;
        FileOutputStream fos = null;

        try {
            //1.创建文件
            File f1 = new File("IMG_7382.JPG");
            File f2 = new File("IMG_7382-222.JPG");

            //2.创建流
            fis = new FileInputStream(f1);
            fos = new FileOutputStream(f2);

            //3.读取写入操作
            byte[] b = new byte[2];
            int len;
            long l = System.currentTimeMillis();
            while((len = fis.read(b)) != -1){
                fos.write(b,0,len);
            }
            long l1 = System.currentTimeMillis();
            System.out.println("节点流复制所花时间为："+(int)(l1-l)+"毫秒");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        //4.关闭流
        if(fos != null){
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(fis != null){
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File f3 = new File("IMG_7382.JPG");
            File f4 = new File("IMG_7382-1111.JPG");

            FileInputStream fi = new FileInputStream(f3);
            FileOutputStream fo = new FileOutputStream(f4);

            bis = new BufferedInputStream(fi);
            bos = new BufferedOutputStream(fo);

            byte[] b1 = new byte[2];
            int len2;
            long l3 = System.currentTimeMillis();
            while((len2 = bis.read(b1))!=-1){
                bos.write(b1,0,len2);

            }
            long l4 = System.currentTimeMillis();
            System.out.println("缓冲流复制所花时间为："+(int)(l4-l3)+"毫秒");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        if(bos !=null){
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(bis != null){
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
