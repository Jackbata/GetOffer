package com.up.lhm.getoffer.kotlin

import android.content.Context
import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import java.io.File

/**
 *
 * @Description:
 * @Author:        肖邦
 * @CreateDate:     2021/10/8 3:41 PM
 */
open class Cost(var name:String){
    init {
        println("init name = $name ")
    }
    constructor(age:Int,  s:String) : this(s) {
        println("constructor age = $age")
    }

}

fun Cost.getNameff():String{
    return "222"
}
open class Cods()

class Sds : View {
  constructor(ctx:Context):super(ctx)
}
class Scdh(var a : String):Cost(""){
    var d:Any?=2
    companion object{

      @JvmStatic  fun start(){

        }
    }
    constructor(s:Int,f:String):this(f){
    }
}
fun main() {
//    val cost = Cost(1, "2")
//    val nameff = cost.getNameff()
//    println("name = $nameff")
//    Scdh(1,"d")
    //10
    println("sdkVersion"+ Build.VERSION.RELEASE)
    println("osVersion"+Build.VERSION.SDK_INT.toString() + File.separator + Build.VERSION.RELEASE)

}