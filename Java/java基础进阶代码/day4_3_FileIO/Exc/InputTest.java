package day4_3_FileIO.Exc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Auther:sommer1111
 * @date 2020/4/11 15:57
 */
public class InputTest {
    //从键盘输入字符串，要求将读取到的整行字符串转成大写输出。
    // 然后继续 进行输入操作，直至当输入“e”或者“exit”时，退出程序。

    //输入整行字符，BufferedReader.readline()
    //循环输入：while
    //小写转大写：toUpperCase()
    //输入字符BufferedReader
    //键盘输入：输入流 InputStream(System.in)

    public static void main(String[] args) {
        System.out.print("请输入要打印的字符串：");
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        try {
            //1.创建文件


            String s = null;
            int len;
            //2.读取文件
            while((s=bu.readLine()) != null){
                if(s.equalsIgnoreCase("e") ||s.equalsIgnoreCase("exit")){

                    System.out.println("输入结束！");
                    break;
                }else{
                    System.out.println(s.toUpperCase());
                    System.out.println("请重新输入：");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭流
            if(bu != null){
                try {
                    bu.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



        }
    }


}
