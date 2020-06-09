package cn.code.day3_25mieju;

import java.lang.annotation.*;

@Repeatable(MyAnnotions.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.MODULE})
public @interface MyAnnotation {
    String value();
}
