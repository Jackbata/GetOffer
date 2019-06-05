package com.up.lhm.getoffer.notes;

/**
 * @author lianghaimiao
 * @date 2019/5/11
 * @function 注解测试
 */

public class TestNotes {

    @TestAnnotate(index = 1,name= "李四")
    @GetUrl(url = "https://www.baidu.com/s?i")
    private void initView() {

    }

    @TestAnnotate(index = 1,name= "李4")
    @GetUrl(url = "https://www.baidu.com/")
    private void initView2() {

    }
}
