package com.up.lhm.getoffer.singleton;

import java.util.ArrayList;

/**
 * @author lianghaimiao
 * @date 2019/3/11
 * @function
 */

public  class Student {


    public final ArrayList<String> list = new ArrayList<>();

    public String name;

    private void setName(int sex, Student stu) {
        sex = 20;
        stu.name = "xiaohon";
    }

    public void setData(String q) {
        list.add(q);
        name=q;
    }

}
