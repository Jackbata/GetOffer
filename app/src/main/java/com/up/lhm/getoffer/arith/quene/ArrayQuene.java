package com.up.lhm.getoffer.arith.quene;

/**
 * @author lianghaimiao
 * @date 2019/4/22
 * @function 队列-顺序结构-数组实现 先进献出
 */

public class ArrayQuene<E> implements IQuene<E> {


    private Object[] mArr;
    private int mCapaCity = 10;
    /**
     * 记录下一个入队元素队位置
     */
    private int mRear;
    /**
     * 队首元素队位置
     */
    private int mFont;

    public ArrayQuene(int capaCity) {
        mCapaCity = capaCity < mCapaCity ? capaCity + 1 : mCapaCity;
        mArr = new Object[mCapaCity];
        mRear = 0;
        mFont = 0;
    }

    @Override
    public int getSize() {
        return (mRear - mFont + mCapaCity) % mCapaCity;
    }

    @Override
    public boolean isEmpty() {
        return mRear == mFont;
    }


    @Override
    public void enquene(E o) {
        if (getSize()== mCapaCity-1) {
            resize();
        }
        mArr[mRear] = o;
        mRear=(mRear+1)%mCapaCity;

    }

    private void resize() {
        mCapaCity = mCapaCity + (mCapaCity >> 2);
        Object[] objects = new Object[mCapaCity];
        System.arraycopy(mArr,mFont,objects,0,getSize());
        mArr=objects;
        mFont=0;mRear=getSize();
    }

    @Override
    public E dequene() {
        if (isEmpty()) {
            throw new QueueEmptyExpection("队列元素为空");
        }

        Object o = mArr[mFont];
        mArr[mFont] = null;
        mFont=(mFont+1)%mCapaCity;
        return (E)o;

    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new QueueEmptyExpection("队列元素为空");
        }
        Object o = mArr[mFont];
        return (E) o;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            throw new QueueEmptyExpection("队列元素为空");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <mArr.length; i++) {
             sb.append(mArr[i]).append("->");
        }
        return sb.toString();
    }
}
