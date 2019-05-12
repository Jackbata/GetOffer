package com.up.lhm.getoffer.arith.stack;

import com.up.lhm.getoffer.arith.node.LinkedNode;

/**
 * @author lianghaimiao
 * @date 2019/4/23
 * @function
 */

public class LinkedStack<E> implements IStack<E> {

    private LinkedNode top = null;

    private int size = 0;

    public LinkedStack() {
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(E o) {

        LinkedNode p = new LinkedNode(o, top);
        top = p;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new StackEmptyExpection("堆栈元素为空");
        }
        LinkedNode next = top.next;
        top = next;
        size--;
        return (E) next.mdata;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new StackEmptyExpection("堆栈元素为空");
        }
        LinkedNode next = top.next;
        return (E) next.mdata;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            throw new StackEmptyExpection("堆栈元素为空");
        }
        StringBuilder sb = new StringBuilder();
        LinkedNode<Integer> temp = top;
        while (temp.next != null) {
            Object mdata =  temp.next.mdata;
            sb.append(mdata).append("->");
            temp = temp.next;
        }
        return sb.toString();
    }
}
