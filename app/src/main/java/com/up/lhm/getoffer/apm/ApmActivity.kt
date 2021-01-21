package com.up.lhm.getoffer.apm

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.up.lhm.getoffer.R
import com.up.lhm.getoffer.apm.apmutil.Sampler
import com.up.lhm.getoffer.mvp.base.BaseActivity
import com.up.lhm.getoffer.recycle.RecyclerviewActivity
import com.up.lhm.hmtools.system.IntentUtil
import kotlinx.android.synthetic.main.activity_apm.*

/**
 * @Description: 性能检测
 * @Author: 肖邦
 * @CreateDate: 2021/1/21 7:24 PM
 */
class ApmActivity : BaseActivity() {
    companion object {
        @JvmStatic
        fun start(context: Context?, finishSelf: Boolean) {
            val args = Bundle()
            IntentUtil.redirect(context, ApmActivity::class.java, finishSelf, args)
        }
    }
    override fun getLayoutId(): Int {
        return R.layout.activity_apm
    }

    override fun initData() {}
    override fun setLinister() {
        btn_next_apm?.setOnClickListener {
            Sampler.getInstance().init(applicationContext, 3000L)
            Sampler.getInstance().start()
        }
    }
}