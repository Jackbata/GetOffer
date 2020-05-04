package com.up.lhm.getoffer.kotlin


/**
 *
 * @author lianghaimiao
 * @date 2020-04-25
 * @function
 */
 
fun main(args:Array<String>){
    val get = Ted().get("e")
    println(get);
//    val sd: Int = test()//数字字面栈下划线
//    println(sd);
var aws =12
    when(aws){
        23-> println("23")
        12-> println("333")
    }
}

private fun test(): Int {
    var a: IntArray = intArrayOf(3, 2, 3)
    a[1] = 3
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
