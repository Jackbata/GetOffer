package com.up.lhm.getoffer.recycle.base;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @Description: 禁止滑动recycleview
 * @Author: 肖邦
 * @CreateDate: 2020/12/12 6:06 PM
 */
public class NoScrollRecycleView extends RecyclerView {
    public NoScrollRecycleView(@NonNull Context context) {
        super(context);
    }

    public NoScrollRecycleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollRecycleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return false;
    }
}
