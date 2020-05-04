package com.up.lhm.getoffer.net.okhttp;

import com.up.lhm.getoffer.mvp.base.IbaseView;

/**
 * @author lianghaimiao
 * @date 2020-04-23
 * @function
 */

public interface Contract {
    interface OkhttpView extends IbaseView {
        /**
         * 展示结果
         */
       void showResult(String result);
    }

    interface OkhttpPresent {
        void getRequst();
        void postRequst();

    }
}
