package com.up.lhm.getoffer.singleton;

/**
 * @author lianghaimiao
 * @date 2019/3/7
 * @function
 */

public class SingleTon {



 /**
     * 1.私有构造函数，避免其他类创建实例
     */
    private SingleTon() {}

    /**
     * 2.static关键字：静态方法只能引用静态的成员变量
     * volatite关键字：禁止创建对象的过程中进行指令重排（正常创建对象的顺序是：1.给对象分配内存、2.初始化对象、3.将对象地址指向引用；如果不是volite关键字则有可能是132
     * 的顺序，这样多线程并发时，就可能会有线程拿到一个未被初始化的对象）
     */
    private volatile static SingleTon singleTon;

    /**
     * static：支持类名点调用
     */
    public static SingleTon getInstance() {
        /**
         *避免多线程情况下，线程阻塞；若不加该判空，则每个线程都要等另一个线程释放锁，才能获取实例
         */
        if (singleTon == null) {
            /**
             * 避免创建多个实例
             */
            synchronized (SingleTon.class) {
                /**
                 *避免创建多个实例
                 */
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}
