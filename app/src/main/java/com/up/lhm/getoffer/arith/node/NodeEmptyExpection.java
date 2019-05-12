package com.up.lhm.getoffer.arith.node;

/**
 * @author lianghaimiao
 * @date 2019/4/22
 * @function 出队或取队首元素时为空
 */

public class NodeEmptyExpection extends RuntimeException {

    public NodeEmptyExpection(String message){
        super(message);
    }
}
