package com.up.lhm.getoffer.genericity;

import com.up.lhm.getoffer.singleton.Student;

/**
 * @author lianghaimiao
 * @date 2019/4/19
 * @function
 */

public class RunClass {
    public static void main(String[] args) {
        JsonCallback<Student> js = new JsonCallback<Student>();
        Student back = js.back();

    }
}
