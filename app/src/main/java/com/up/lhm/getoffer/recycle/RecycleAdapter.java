package com.up.lhm.getoffer.recycle;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.up.lhm.getoffer.R;

import java.util.ArrayList;

/**
 * @author barry
 * @date 2020/7/1
 * @function
 */


public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.FollowReadViewHolder> {
    private Context mContext;


    private ArrayList<RecycleTestBean> mList;


    public RecycleAdapter(Context context, ArrayList<RecycleTestBean> children) {
        mContext = context;
        mList = children;
    }

    @NonNull
    @Override
    public FollowReadViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_recycle_test, viewGroup, false);
        return new FollowReadViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowReadViewHolder followReadViewHolder, int i) {
        RecycleTestBean recycleTestBean = mList.get(i);
        followReadViewHolder.content.setText(recycleTestBean.content);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public static class FollowReadViewHolder extends RecyclerView.ViewHolder {

        private TextView content;

        public FollowReadViewHolder(View view) {
            super(view);
            content = view.findViewById(R.id.tv_content);
        }
    }

}
