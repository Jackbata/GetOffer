package com.up.lhm.getoffer.arith.quene;


import com.up.lhm.getoffer.arith.node.LinkedNode;

/**
 * @author lianghaimiao
 * @date 2019/4/23
 * @function
 */

public class LinkedQuene<E> implements IQuene<E> {

    private LinkedNode font;
    private int size = 0;
    private LinkedNode rear;

    public LinkedQuene() {
        font = new LinkedNode();
        rear = font;
        size=0;
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
    public void enquene(E o) {
        LinkedNode p = new LinkedNode<E>(o, null);
        rear.next=p;
        rear = p;
        size++;
        LinkedNode ffont = font;
    }

    @Override
    public E dequene() {
        if (isEmpty()) {
            throw new QueueEmptyExpection("队列元素为空");
        }
        LinkedNode first = font.next;
        font.next = first.next;
        size--;
        if (size < 1) {
            rear = font;
        }
        return (E) first.mdata;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new QueueEmptyExpection("队列元素为空");
        }
        LinkedNode first = font.next;
        return (E) first.mdata;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            throw new QueueEmptyExpection("队列元素为空");
        }
        StringBuilder sb = new StringBuilder();
        LinkedNode<Integer> temp = font.next;
        while (temp.next != null) {
            Integer mdata = temp.mdata;
            sb.append(mdata).append("->");
            temp = temp.next;
        }
        return sb.toString();
    }
}
