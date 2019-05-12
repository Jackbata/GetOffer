package com.up.lhm.annotationlibs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lianghaimiao
 * @date 2019/5/11
 * @function
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
public @interface BindVieww {
    int value() default 1;
}
