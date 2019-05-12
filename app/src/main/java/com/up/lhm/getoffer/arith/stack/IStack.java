package com.up.lhm.getoffer.arith.stack;

/**
 * @author lianghaimiao
 * @date 2019/4/23
 * @function
 */

public interface IStack<E> {
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
    void push(E o);

    /**
     * 出队
     */
    E pop();

    /**
     * 取出队首元素
     */
    E peek();
}
