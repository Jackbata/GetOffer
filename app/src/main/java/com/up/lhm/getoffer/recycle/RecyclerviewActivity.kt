package com.up.lhm.getoffer.recycle

import android.animation.ValueAnimator
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.ScaleAnimation
import android.widget.Button
import com.nineoldandroids.animation.ObjectAnimator
import com.up.lhm.getoffer.R
import com.up.lhm.getoffer.mvp.base.BaseActivity
import com.up.lhm.getoffer.recycle.base.TopSmoothLayoutManager
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
    private var mAdapter: RecycleAdapter? = null
    private var mList: ArrayList<RecycleTestBean>? = null
    private var curr: Int = 0
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
            var text = ""
            when (i % 3) {
                0 -> text = "第 $i 题：I want to sleep I want to sleep I want to sleepI want to sleepI want to sleepI want to sleep"
                1 -> text = "第 $i 题：sleepI want to sleep"
                else ->text = "第 $i 题：I want to sleep I want to sleep I want to sleepI "
            }

            recycleTestBean.content = if (i==9) "第 $i 题：I want to sleep I want to sleep I want to  to sleep I want to sleepI want to sleepI want to sleepI want to sleepsleep I want to sleepI want to sleepI want to sleepI want to sleep" else text
            recycleTestBean.isleft = i % 2 == 0
            recycleTestBean.id = i
            recycleTestBean.isRead = i == 0
            mList!!.add(recycleTestBean)
        }
        mAdapter = RecycleAdapter(this, mList)
        mRecycle!!.adapter = mAdapter
        mRecycle?.post { getHint() }

    }


    override fun setLinister() {
        btnNext!!.setOnClickListener(View.OnClickListener {
            val size = mList!!.size - 1
            if (curr >= size) {
                val firsthand = mList!![curr]
                firsthand?.isRead = false
                mAdapter?.notifyDataSetChanged()
                Log.d("demo测试", "curr=$curr,已经到最后一条")
                return@OnClickListener
            }

            val firstVisibleItemPosition = linearLayoutManager!!.findFirstVisibleItemPosition()
            val findLastCompletelyVisibleItemPosition = linearLayoutManager?.findLastCompletelyVisibleItemPosition()
            val next = firstVisibleItemPosition + 1

            if (findLastCompletelyVisibleItemPosition == size || firstVisibleItemPosition == size) {
                ToastUtils.showShort("不用滑了，已经到底了")
            } else {
                //滑动到下一条
                curr = firstVisibleItemPosition
                mRecycle?.smoothScrollToPosition(next)
                mRecycle?.postDelayed({ getHint() }, 500)
            }

            val firsthand = mList!![curr]
            firsthand?.isRead = false
            if (++curr <= size) {
                val recycleTestBean = mList!![curr]
                recycleTestBean.isRead = true
                mAdapter?.notifyDataSetChanged()
            }
            startTime()

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

    fun startTime(){
        var toast=true
        val animation: ObjectAnimator = ObjectAnimator.ofFloat( tv_progre, "scaleX", 1f, 0f)
        //设置播放时间
        //设置播放时间
        animation.duration = 10000
        tv_progre.pivotX=0f
        animation.interpolator=LinearInterpolator()
        animation.start()

        animation.addUpdateListener {
            if (it.currentPlayTime>=5000&&toast){
                toast=false
                ToastUtils.showLong("5秒了")
            }
            if (it.currentPlayTime>=8000){
                ToastUtils.showLong("结束了")
                animation.currentPlayTime=0
            }
            Log.d("demo测试",  "it.currentPlayTime=${it.currentPlayTime}")
           }
    }
}