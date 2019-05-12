package com.up.lhm.getoffer.mvp.activity;

import com.up.lhm.getoffer.mvp.base.IbaseView;

/**
 * @author lianghaimiao
 * @date 2019/3/14
 * @function
 */

public interface Contract {
    interface Xview extends IbaseView {
        void showview();
    }

    interface Xpresent extends IbaseView{
        void setdata();
    }
}
