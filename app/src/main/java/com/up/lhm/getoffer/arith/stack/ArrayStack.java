package com.up.lhm.getoffer.arith.stack;


/**
 * @author lianghaimiao
 * @date 2019/4/23
 * @function 栈--顺序结构
 */

public class ArrayStack<E> implements IStack<E> {

    private Object[] mArr;


    private int mCapaCity = 10;

    private int size;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int size) {
        mCapaCity = size <= 0 ? mCapaCity : size;
        mArr = new Object[mCapaCity];
        size = 0;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void push(E o) {
        mArr[size]=o;
        size++;
        if (size==mCapaCity){
            resize();
        }
    }

    private void resize() {
        mCapaCity = mCapaCity + (mCapaCity >> 2);
        Object[] objects = new Object[mCapaCity];
        System.arraycopy(mArr,0,objects,0,getSize());
        mArr=objects;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new StackEmptyExpection("堆栈元素为空");
        }

        E o = (E) mArr[size - 1];
        mArr[size - 1]=null;
        size--;
        return o;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new StackEmptyExpection("堆栈元素为空");
        }
        E o = (E) mArr[size - 1];
        return o;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            throw new StackEmptyExpection("堆栈元素为空");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <mArr.length; i++) {
            sb.append(mArr[i]).append("->");
        }
        return sb.toString();
    }
}
