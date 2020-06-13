package day4_3_FileIO.IOTest;

import java.io.*;

/**
 * @Auther:sommer1111
 * @date 2020/4/9 20:42
 */
public class ObjectStreamTest {
    public static void main(String[] args) {
        //存入数据操作
        //1.创建流
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("objece.dat"));

            //2.操作
            oos.writeObject(new String("we are the world"));
            oos.flush();
            oos.writeObject(new Person("somme",21,new Price(30000)));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭流
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        //载入对象操作
        //1.创建对象
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("objece.dat"));

            //2.载入
            Object o = ois.readObject();
            Person o1 = (Person)ois.readObject();
            System.out.println(o);
            System.out.println(o1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
        }

        //3.关闭流
        if(ois != null){
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
