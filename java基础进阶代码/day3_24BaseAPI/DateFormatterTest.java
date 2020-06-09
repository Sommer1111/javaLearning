package cn.code.day3_24BaseAPI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.regex.Pattern;

public class DateFormatterTest {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String s = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(s);

        //解析
        TemporalAccessor accessor = dateTimeFormatter.parse("2020-03-24 04:04:47");
        System.out.println(accessor);


    }
}
