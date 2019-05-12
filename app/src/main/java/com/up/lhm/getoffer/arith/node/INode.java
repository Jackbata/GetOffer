package com.up.lhm.getoffer.arith.node;

/**
 * @author lianghaimiao
 * @date 2019/4/23
 * @function
 */

public interface INode<E> {
    /**
     * 1.元素个数
     */
    int getSize();

    /**
     * 2.是否为空
     */
    boolean isEmpty();

    /**
     * 3.s是否包含e
     */
    boolean contain(E e);

    /**
     * 4.返回元素在列表中队位置
     */
    int indexOf(E e);

    /**
     * 5.将元素插入i位置
     */
    void inset(int i, E e);

    /**
     * 6.将元素插入p之前
     */
    void insetBefore(E p, E e);

    /**
     * 7.将元素插入p之后
     */
    void insetAfater(E p, E e);

    /**
     * 8.移除i位置元素，并将其返回
     */
    E remove(int i);

    /**
     * 9.移除e
     */
    boolean remove( E e);

    /**
     * 10.替换i位置元素
     */
    E replace(int i, E e);

    /**
     * 11.获取i位置元素
     */
    E get(int i);


}
