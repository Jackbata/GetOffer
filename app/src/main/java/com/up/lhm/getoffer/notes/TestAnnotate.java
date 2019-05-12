package com.up.lhm.getoffer.notes;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lianghaimiao
 * @date 2019/5/11
 * @function 注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface TestAnnotate {
    String name() default "张三";
    int age() default 23;
    int index();
}
