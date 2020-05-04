package com.up.lhm.getoffer.kotlin

/**
 *
 * @author lianghaimiao
 * @date 2020-04-25
 * @function
 */

class Ma(override var s: String, override val df: Int) : Qws(),See{

    override fun getsd() {
        println(s+"=="+df)
    }


}