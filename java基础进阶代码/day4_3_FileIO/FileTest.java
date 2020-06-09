package cn.code.day4_3_FileIO;

import java.io.File;

/**
 * @Auther:sommer1111
 * @date 2020/4/3 15:52
 */
public class FileTest {
    public static void main(String[] args) {
        File file1 = new File("FileTest.java");
        File file2 = new File("D:\\计算机学习");
        File file3 = new File("D:\\Java\\test\\basic-code\\","FileTest.java");
        File file4 = new File(file2,"here.txt");

        //public String getAbsolutePath()：获取绝对路径
        //  public String getPath() ：获取路径
        //  public String getName() ：获取名称
        //  public String getParent()：获取上层文件目录路径。若无，返回null
        //  public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
        //  public long lastModified() ：获取最后一次的修改时间，毫秒值
        //  public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
        //  public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组

        String s = file3.getAbsolutePath();
        System.out.println(s);
        String parent = file3.getParent();
        System.out.println(parent);
        String[] list = file2.list();
        for(String s1:list){
            System.out.println(s1);
        }
        File[] files = file2.listFiles();
        for(File f:files){
            System.out.println(f);
        }

    }
}
