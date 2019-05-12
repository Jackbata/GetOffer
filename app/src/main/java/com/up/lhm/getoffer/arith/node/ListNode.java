package com.up.lhm.getoffer.arith.node;

/**
 * @author lianghaimiao
 * @date 2019/4/23
 * @function
 */

public class ListNode<E> implements INode<E> {


    public Node<E> head;
    public int size;


    public ListNode() {
        size = 0;
        head = new Node();
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
    public boolean contain(E e) {
        Node p = head.next;
        while (p != null) {
            if (e.equals(p.data)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    @Override
    public int indexOf(E e) {
        if (!contain(e)) {
            return -1;
        }
        Node p = head.next;
        int count = 0;
        while (p != null) {
            if (p.data.equals(e)) {
                return count;
            }
            count++;
            p = p.next;
        }

        return count;
    }

    @Override
    public void inset(int i, E e) {

        Node p = head.next;
        Node pre = getpreNode(i);
        Node node = new Node(pre, e);
        p.next=pre;
        size++;
    }

    /**
     * 获取i元素之前的元素
     * @param i
     */
    private Node getpreNode(int i) {
        if (i >= size) {
            throw new NodeEmptyExpection("越界");
        }
        Node p = head.next;
        if (i==0){
            return p;
        }
        int count = 0;
        while (p!=null){
            if (count==i-1){
                return p;
            }
           p= p.next;
        }

        return null;
    }


    @Override
    public void insetBefore(E p, E e) {
        if (!contain(p)) {
            Node node = new Node(null, e);
            head.next=node;
            return;
        }
        int i = indexOf(p);
        inset(i-1, e);
        size++;

    }

    @Override
    public void insetAfater(E p, E e) {
        Node node = new Node(null, e);
        if (size==0) {
            head.next=node;
            return;
        }
        int i = indexOf(p);
        Node preNode = getpreNode(i);
        preNode.next=node;
        size++;

    }

    @Override
    public E remove(int i) {
        if (size>=0 ||size<=i){
            throw new NodeEmptyExpection("越界");
        }
        Node preNode = getpreNode(i);
        Node next = preNode.next.next;
        preNode.next=next;
        size--;
        return (E) preNode.data;
    }

    @Override
    public boolean remove( E e) {

        int i = indexOf(e);
        E remove = remove(i);
        return remove==null;
    }

    @Override
    public E replace(int i, E e) {
        Node getpreNode = getpreNode(i);
        Node next = getpreNode.next;
        next.data=e;
        return (E) next;
    }

    @Override
    public E get(int i) {
        if (i >= size) {
            throw new NodeEmptyExpection("越界");
        }
        int count = 0;
        Node p = head.next;
        while (p != null) {
            if (count == i) {
                return (E) p.data;
            }
            count++;
            p = p.next;
        }

        return null;
    }

}
