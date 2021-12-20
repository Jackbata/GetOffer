package com.libs.mathlib.letc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/11/1 10:34 AM
 */
public class reverK {
  /**
   * Definition for singly-linked list.

   */
  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
      return "ListNode{" +
          "val=" + val;
    }
  }
  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(3);
    ListNode listNode4 = new ListNode(4);
    ListNode listNode5= new ListNode(5);
    listNode1.next=listNode2;
    listNode2.next=listNode3;
    listNode3.next=listNode4;
    listNode4.next=listNode5;
    ListNode listNode = reverseKGroup(listNode1, 2);
    System.out.println("222---"+listNode.toString());
  }
  public static ListNode reverseKGroup(ListNode head, int k) {
    if(k==1||head==null||head.next==null) return head;

    ListNode temp=null;
    ListNode heads=head;
    int index=0;
    while(heads!=null){
      ListNode cur=heads.next;
      if(temp==null){
        temp=heads;
      }else{
        heads.next=null;
        temp.next=heads;
        heads=cur;
      }
      index++;
      if(k==index){
        reverse(temp);
        temp=null;
        index=0;
      }
    }

    return head;
  }

  public static ListNode reverse(ListNode head){
    if(head==null||head.next==null) return head;
    ListNode pre=null;
    while(head!=null){
      ListNode temp = head.next;
      head.next=pre;
      pre=head;
      head=temp;
    }
    return pre;
  }
}
