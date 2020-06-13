package day4_3_FileIO.IOTest;

import java.io.*;

/**
 * @Auther:sommer1111
 * @date 2020/4/9 17:07
 */
public class SystemTest {
    public static void main(String[] args) {
        BufferedReader b = null;
        try {

            InputStreamReader isr = new InputStreamReader(System.in);
            b = new BufferedReader(isr);

            while(true){
                System.out.print("请输入字符串：");
                String data = b.readLine();
                if(data.equalsIgnoreCase("e") || data.equalsIgnoreCase("exit")){
                    break;
                }
                System.out.println(data.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        if(b!=null){
            try {
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
