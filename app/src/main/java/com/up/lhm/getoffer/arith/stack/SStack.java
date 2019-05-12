package com.up.lhm.getoffer.arith.stack;


/**
 * @author lianghaimiao
 * @date 2019/4/23
 * @function
 */

public class SStack {
    public static void main(String[] args) {

//        testArray();
        testLinked();

    }

    private static void testLinked() {
        LinkedStack<Integer> as = new LinkedStack<Integer>();
        for (int i = 0; i < 25; i++) {
            as.push(i);
        }
        print(as);
    }

    private static void testArray() {
        ArrayStack<Integer> as = new ArrayStack<>(4);
        for (int i = 0; i < 25; i++) {
            as.push(i);
        }
        print(as);

    }
    private static void print(IStack stack) {
        System.out.println(stack.toString());

        boolean empty = stack.isEmpty();
        int size = stack.getSize();
        int dequene = (int) stack.pop();
        int peek = (int) stack.peek();

        System.out.println("是否空：" + empty + "  ；大小：" + size + "  ；出队" + dequene + "  ：取出首位元素" + peek);
        System.out.println(stack.toString());
    }
}
