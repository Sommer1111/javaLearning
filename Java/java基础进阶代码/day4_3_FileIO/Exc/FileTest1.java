package day4_3_FileIO.Exc;

import java.io.File;
import java.io.IOException;

/**
 * @Auther:sommer1111
 * @date 2020/4/3 17:28
 */


public class FileTest1 {
    public static void main(String[] args) throws IOException {
        //利用File构造器，new 一个文件目录file
        File file = new File("C:\\Users\\1\\Pictures\\test");

        // 1)在其中创建多个文件和目录
        File file1 = new File("C:\\Users\\1\\Pictures\\test","hello.txt");
        file1.createNewFile();
        File file2 = new File("C:\\Users\\1\\Pictures\\test","today");
        file2.createNewFile();


        // 判断指定目录下是否有后缀名为.jpg的文件
        // 如果有，就输出该文件名称
        boolean d = file.isDirectory();
        if(d){
            if(file.exists()){
                String[] list = file.list();
                for(String s:list){
                    if(s.endsWith(".jpg")){
                        System.out.println(s);
                        System.out.println("图片打印完毕，接下来是文件打印");
                        System.out.println("********************************");
                    }

                }

                // 遍历指定目录所有文件名称，包括子文件目录中的文件。————>用递归！（算法的大用！）
                File[] files = file.listFiles();
                for(File f:files){
                    if(f.isDirectory()){
                        File[] files1 = f.listFiles();
                        for(File f1:files1){
                            f1.listFiles();
                        }
                        System.out.println("_________________________________");
                    }else{
                        System.out.println("剩下文件");
                        System.out.println(f);
                    }

                }
            }

        }

    }

    // 2)编写方法，实现删除file中指定文件的操作
    // 拓展2：删除指定文件目录及其下的所有文件
    public void del(File s){
        if(s.isDirectory()){
            File[] files3 = s.listFiles();
            for(File f3:files3){
                f3.delete();
            }
            System.out.println("目录下的文件删除完毕！");
        }
        boolean delete = s.delete();
        System.out.println("删除"+delete);
    }

    // 拓展1：并计算指定目录占用空间的大小
    public void calcu(File s1){
        if(s1.isDirectory()){
            File[] files4 = s1.listFiles();
            long l=0;
            for(File f4:files4){
                l += f4.length();
            }
            System.out.println(l);
        }else{
            System.out.println(s1.length());
        }

    }

}
