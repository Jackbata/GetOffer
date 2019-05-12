package com.up.lhm.getoffer.arith.node;

/**
 * @author lianghaimiao
 * @date 2019/4/24
 * @function
 */

public class MyLinkedList {


    private int size;
    private Node head;


    public class Node{
        public Node next;
        public  int val;
        public Node(Node node,int data){
            this.next=node;
            this.val=data;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head=new Node(null,0);
        size=0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index>=size||index<-1){
            return -1;
        }
        if (index<0){
            return head.val;
        }
        Node p = head.next;
        int count =0;
        while(p!=null){
            if(count ==index){
                return p.val;
            }
            count++;
            p=p.next;
        }
        return -1;

    }
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node p = head;
        Node first=  new Node(p.next,val);
        p.next=first;
        size++;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node p=  new Node(null,val);
        Node first = head;
        while(first!=null){
            if(first.next==null){
                first.next=p;
                size++;
                return;
            }
            first=first.next;
        }

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index>size){
            return;
        }
        if(size==index){
            addAtTail(val);
            return;
        }
        if (index<0){
            head.val=val;
            return;
        }
        Node p = head;
        int count =-1;
        while(p!=null){
            if(count==index-1){
                Node curr=  new Node(p.next,val);
                p.next=curr;
                size++;
            }
            count++;
            p=p.next;
        }
    }
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index<0||index>=size){
            return;
        }
        Node p = head;
        int count =-1;
        while(p!=null){
            if(count==index-1){
                Node pre= p.next;
                Node next= pre.next;
                p.next=next;
                size--;
                return;
            }
            count++;
            p=p.next;
        }


    }
}
