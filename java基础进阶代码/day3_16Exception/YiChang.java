package cn.code.day3_16Exception;

import java.util.Scanner;

public class YiChang{
    public static void main(String[] args) {
        while(true){
            try {
                int i = Integer.parseInt(new Scanner(System.in).next());
                int j = Integer.parseInt(new Scanner(System.in).next());
                System.out.println(ecm(i,j));

            }catch (NumberFormatException e) {
                System.out.println("输入数据类型出错");
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("缺少数据");
            }catch(ArithmeticException e){
                System.out.println("除0");
            }catch(MyException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int ecm(int i,int j){
        if(i<0 || j<0){
            throw new MyException("输入为负数");
        }
        return i/j;
    }
}


//当输入为负数时手动抛出异常
class MyException extends RuntimeException{
    static final long serialVersionUID = -7034190745766939L;

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}

