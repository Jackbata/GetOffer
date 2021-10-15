package com.up.lhm.getoffer.kotlin


/**
 *
 * @author lianghaimiao
 * @date 2020-04-25
 * @function
 */
 
fun main(args:Array<String>){
//    val get = Ted().get("e")
//    println(get);
//    val sd: Int = test()//数字字面栈下划线
//    println(sd);
//var aws =12
//    when(aws){
//        23-> println("23")
//        12-> println("333")
//    }
    val a: Int = 100
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    val b: Int = 10000
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b

    println(boxedA === anotherBoxedA) // true
    println(boxedB === anotherBoxedB) // false
    println(boxedB == anotherBoxedB) // true
}

private fun test(): Int {
    var a: IntArray = intArrayOf(3, 2, 3)
    a[1] = 3
//    val array2 = arrayOfNulls<Int>(4)
//    val array2 = arrayOf("3","3",3)
//    val array2 = Array<String>(2) { it -> "$it" }
    val string1 = Array(3){it->it.toInt()}//创建固定长度数组
    val string = arrayOfNulls<String>(3)//创建固定长度空数组
    val int = IntArray(2) //创建基本类型数组
    val int1 = intArrayOf(2,4,5) //创建基本类型数组

    val long = LongArray(2) //创建基本类型数组

    val string2 = arrayOf("3","4")//创建固定元素数组
    var size =  string.size//获取数组长度
    string[1]="33"
    string[2]=3.toString()
    var arr = IntArray(3) { it * 4 }
    println("" + arr[0] + "--" + arr[2])

    println("----------------")

    var name = "23"
    name = "44"
    println(name)
    println("----------------")
    var q: Int = 12;
    var q2: String = "2";
    var qby: Byte = 1;
    var qs: Short = 12;
    var ql: Long = 12;
    var qf: Float = 12f;
    var qd: Double = 12.8;
    var qb: Boolean = true;
    println("----------------")
    println("*")
    println("**")
    println("***")
    println("*****")
    println("****")
    println("***")
    println("**")
    println("*")
    println("----------------")
    println(gett(2, "4=="));
    println(addnum(2f, 3));
    val sd: Int = 1_22_3//数字字面栈下划线
    return sd
}

fun addnum(i: Float, i1: Long): Float {
return i+i1;
}

fun gett(i: Int, s: String):String{
return s+i;
}
