package com.up.lhm.getoffer.arith.quene;

/**
 * @author lianghaimiao
 * @date 2019/4/22
 * @function 队列抽象数据类型
 */

public interface IQuene<E> {

    /**
     * 队列大小
     */
    int getSize();

    /**
     * 是否为空
     */
    boolean isEmpty();

    /**
     * 入队
     */
    void enquene(E o);

    /**
     * 出队
     */
    E dequene();

    /**
     * 取出队首元素
     */
    E peek();

}
