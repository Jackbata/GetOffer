package com.up.lhm.getoffer.arith.stack;

/**
 * @author lianghaimiao
 * @date 2019/4/22
 * @function 出队或取队首元素时为空
 */

public class StackEmptyExpection extends RuntimeException {

    public StackEmptyExpection(String message) {
        super(message);
    }
}
