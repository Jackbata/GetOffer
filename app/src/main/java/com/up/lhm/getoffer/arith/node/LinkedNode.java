package com.up.lhm.getoffer.arith.node;

/**
 * @author lianghaimiao
 * @date 2019/4/23
 * @function
 */

public class LinkedNode<E>{
    public LinkedNode next;
    public  E mdata;

    public LinkedNode(){
        this(null,null);
    }

    public LinkedNode( E data,LinkedNode node) {
        this.next=node;
        this.mdata=data;

    }


}
