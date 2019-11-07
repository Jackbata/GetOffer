package com.up.lhm.getoffer.glide;

import com.up.lhm.getoffer.mvp.base.IbaseView;

/**
 * @author lianghaimiao
 * @date 2019/3/14
 * @function
 */

public interface GlideContract {
    interface Xview extends IbaseView {
        void showview();
    }

    interface Xpresent extends IbaseView{
        void setdata();
    }
}
