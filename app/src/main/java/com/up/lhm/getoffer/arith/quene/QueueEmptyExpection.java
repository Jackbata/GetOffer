package com.up.lhm.getoffer.arith.quene;


/**
 * @author lianghaimiao
 * @date 2019/4/22
 * @function 出队或取队首元素时为空
 */

public class QueueEmptyExpection extends RuntimeException {
    public QueueEmptyExpection(String message){
        super(message);
    }
}
