package com.up.lhm.getoffer.arith.quene;

/**
 * @author lianghaimiao
 * @date 2019/4/22
 * @function 队列
 */

public class CQuene {
    public static void main(String[] args) {

//        testArray();
        testLinked();

    }

    private static void testLinked() {
        LinkedQuene linkedQuene = new LinkedQuene<Integer>();

        for (int i = 0; i < 15; i++) {
            linkedQuene.enquene(i);
        }
        print(linkedQuene);
    }

    private static void testArray() {
        ArrayQuene arrayQuene = new ArrayQuene<Integer>(23);
        for (int i = 0; i < 15; i++) {
            arrayQuene.enquene(i);
        }
        print(arrayQuene);
    }

    private static void print(IQuene quene) {
        System.out.println(quene.toString());

        boolean empty = quene.isEmpty();
        int size = quene.getSize();
        int dequene = (int) quene.dequene();
        int peek = (int) quene.peek();

        System.out.println("是否空：" + empty + "  ；大小：" + size + "  ；出队" + dequene + "  ：取出首位元素" + peek);
        System.out.println(quene.toString());
    }

}
