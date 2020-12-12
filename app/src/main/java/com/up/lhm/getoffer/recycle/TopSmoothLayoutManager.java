package com.up.lhm.getoffer.recycle;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * 参考：https://blog.csdn.net/weimingjue/article/details/82805361
 * @Description: 滑动到置顶位置
 * @Author: 肖邦
 * @CreateDate: 2020/12/12 4:42 PM
 */
public class TopSmoothLayoutManager extends LinearLayoutManager {
    public TopSmoothLayoutManager(Context context) {
        super(context);
    }

    public TopSmoothLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public TopSmoothLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        LinearSmoothScroller linearSmoothScroller = new TopSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(position);
        this.startSmoothScroll(linearSmoothScroller);
    }

    class TopSmoothScroller extends LinearSmoothScroller{

        public TopSmoothScroller(Context context) {
            super(context);
        }

        @Override
        protected int getHorizontalSnapPreference() {
            return SNAP_TO_START;//具体见源码注释
        }

        @Override
        protected int getVerticalSnapPreference() {
            return SNAP_TO_START;//具体见源码注释
        }

    }
}
