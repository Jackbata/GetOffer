package com.up.lhm.getoffer.recycle;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.up.lhm.getoffer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author barry
 * @date 2020/7/1
 * @function
 */


public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.FollowReadViewHolder> {
    private Context mContext;


    private ArrayList<RecycleTestBean> mList;
    private static final int Left = 2;
    private static final int right = 1;

    public RecycleAdapter(Context context, ArrayList<RecycleTestBean> children) {
        mContext = context;
        mList = children;
    }

    @NonNull
    @Override
    public FollowReadViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate;
        if (i == Left) {
            inflate = LayoutInflater.from(mContext).inflate(R.layout.item_recycle_test, viewGroup, false);
        } else {
            inflate = LayoutInflater.from(mContext).inflate(R.layout.item_recycle_test_right, viewGroup, false);
        }

        return new FollowReadViewHolder(inflate, i);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowReadViewHolder holder, int position,
        @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowReadViewHolder followReadViewHolder, int position) {
        RecycleTestBean recycleTestBean = mList.get(position);

        if (getItemViewType(position) == Left) {
            followReadViewHolder.content.setText(recycleTestBean.content);
            if (recycleTestBean.isRead) {
                followReadViewHolder.content.setTextColor(mContext.getResources().getColor(R.color.vc8161d));
            } else {
                followReadViewHolder.content.setTextColor(mContext.getResources().getColor(R.color.v000000));
            }
        } else {
            followReadViewHolder.rightcontent.setText(recycleTestBean.content);
            if (recycleTestBean.isRead) {
                followReadViewHolder.rightcontent.setTextColor(mContext.getResources().getColor(R.color.vc8161d));
            } else {
                followReadViewHolder.rightcontent.setTextColor(mContext.getResources().getColor(R.color.v000000));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        RecycleTestBean recycleTestBean = mList.get(position);
        if (recycleTestBean.isleft) {
            return Left;
        }
        return right;
    }

    public static class FollowReadViewHolder extends RecyclerView.ViewHolder {

        private TextView content;
        private TextView rightcontent;

        public FollowReadViewHolder(View view, int viewtype) {
             super(view);
            if (viewtype == Left) {
                content = view.findViewById(R.id.tv_content);
            } else {
                rightcontent = view.findViewById(R.id.tv_right_content);

            }
        }
    }

}
