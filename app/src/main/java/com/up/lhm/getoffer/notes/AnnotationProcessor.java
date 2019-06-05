package com.up.lhm.getoffer.notes;

import java.lang.reflect.Method;

/**
 * @author lianghaimiao
 * @date 2019/5/11
 * @function
 */

public class AnnotationProcessor {

    public static void main(String[] args) {

        Method[] method = TestNotes.class.getDeclaredMethods();
        for (Method m:method) {
            GetUrl getUrl = m.getAnnotation(GetUrl.class);
            System.out.println(getUrl.url());
            TestAnnotate testAnnotate = m.getAnnotation(TestAnnotate.class);
            System.out.println(testAnnotate.name());

        }
    }
}
