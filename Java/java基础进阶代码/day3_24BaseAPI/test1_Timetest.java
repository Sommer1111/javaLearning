package day3_24BaseAPI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class test1_Timetest {
    public static void main(String[] args) {
        //1.now创建对象
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);


        //of()设置指定的时间
        LocalDate localDate1 = localDate.of(1998, 2, 25);
        System.out.println(localDate1);

        //2.getXxx获取相关属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localTime.getMinute());

        //3.设置相关属性with，它有返回值，回返回相同类型的体现了时间的不可变性
        LocalDateTime localDateTime1 = localDateTime.withHour(12);
        System.out.println(localDateTime1);


    }


}
