package com.up.lhm.getoffer.recycle

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import com.up.lhm.getoffer.R
import com.up.lhm.getoffer.mvp.base.BaseActivity
import com.up.lhm.getoffer.recycle.RecyclerviewActivity
import com.up.lhm.hmtools.system.IntentUtil
import com.up.lhm.hmtools.system.Log
import com.up.lhm.hmtools.system.ToastUtils
import kotlinx.android.synthetic.main.activity_recycleview.*
import java.util.*

/**
 * @Description: recycleview滑动到某个位置
 * @Author: 肖邦
 * @CreateDate: 2020/12/12 2:35 PM
 *
 */
class RecyclerviewActivity : BaseActivity() {
    private var btnNext: Button? = null
    private var mRecycle: RecyclerView? = null
    private var linearLayoutManager: LinearLayoutManager? = null
    private var mList: ArrayList<RecycleTestBean>? = null
    override fun getLayoutId(): Int {
        return R.layout.activity_recycleview
    }

    override fun initBaseView() {
        btnNext = findViewById(R.id.btn_next)
        mRecycle = findViewById(R.id.english_rv)
    }

    override fun initData() {
        linearLayoutManager = TopSmoothLayoutManager(this)
        mRecycle!!.layoutManager = linearLayoutManager
        mList = ArrayList()
        for (i in 0..9) {
            val recycleTestBean = RecycleTestBean()
            recycleTestBean.content = "第" + i + "题：I want to sleep I want to sleep I want to sleepI want to sleepI want to sleepI want to sleep"
            recycleTestBean.id = i
            mList!!.add(recycleTestBean)
        }
        val recycleAdapter = RecycleAdapter(this, mList)
        mRecycle!!.adapter = recycleAdapter
        mRecycle?.post { getHint() }

    }


    override fun setLinister() {
        btnNext!!.setOnClickListener(View.OnClickListener {
            val firstVisibleItemPosition = linearLayoutManager!!.findFirstVisibleItemPosition()
            val next = firstVisibleItemPosition + 1
            if (next == mList!!.size) {
                ToastUtils.showShort("已经到底了")
                return@OnClickListener
            }

         mRecycle?.smoothScrollToPosition(next)
            mRecycle?.postDelayed(object : Runnable {
                override fun run() {
                    getHint()
                }
            }, 500)

        })
    }

    private fun getHint() {
        val firstVisibleItemPosition = linearLayoutManager!!.findFirstVisibleItemPosition()
        val findFirstCompletelyVisibleItemPosition = linearLayoutManager!!.findFirstCompletelyVisibleItemPosition()
        val findLastVisibleItemPosition = linearLayoutManager!!.findLastVisibleItemPosition()
        val findLastCompletelyVisibleItemPosition = linearLayoutManager!!.findLastCompletelyVisibleItemPosition()
        tv_hint.text = "第一个条目：$firstVisibleItemPosition;第一个完全展示：$findFirstCompletelyVisibleItemPosition ，最后一个：${findLastVisibleItemPosition},最后一个完全展示：${findLastCompletelyVisibleItemPosition}"
        Log.d("demo测试", "firstVisibleItemPosition=$firstVisibleItemPosition;findFirstCompletelyVisibleItemPosition=$findFirstCompletelyVisibleItemPosition,findLastVisibleItemPosition=${findLastVisibleItemPosition},findLastCompletelyVisibleItemPosition=${findLastCompletelyVisibleItemPosition}")
    }

    companion object {
        @JvmStatic
        fun start(context: Context?, finishSelf: Boolean) {
            val args = Bundle()
            IntentUtil.redirect(context, RecyclerviewActivity::class.java, finishSelf, args)
        }
    }
}