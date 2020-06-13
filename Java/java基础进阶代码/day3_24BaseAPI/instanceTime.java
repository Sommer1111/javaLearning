package day3_24BaseAPI;

import java.time.Instant;
import java.time.ZoneOffset;

public class instanceTime {
    public static void main(String[] args) {
        //无参创建对象
        Instant instant = Instant.now();
        System.out.println(instant);

        //加上偏移量的时区
        Instant instant2 = Instant.now();

        System.out.println(instant2.atOffset(ZoneOffset.ofHours(8)));

        //带参创建对象
        Instant instant1 = Instant.ofEpochMilli(1234567789999L);
        System.out.println(instant1);

        long l = instant1.toEpochMilli();
        System.out.println(l);




    }

}
