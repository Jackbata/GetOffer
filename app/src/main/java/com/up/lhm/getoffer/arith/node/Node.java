package com.up.lhm.getoffer.arith.node;

/**
 * @author lianghaimiao
 * @date 2019/4/24
 * @function
 */

public class Node <E>{
    public Node next;
    public  E data;

    public Node(){
        this(null,null);
    }

    public Node(Node node, E data) {
        this.next=node;
        this.data=data;

    }
}
