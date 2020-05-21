package com.up.lhm.getoffer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.up.lhm.getoffer.MyAdapter.MyViewHolder;
import com.up.lhm.getoffer.bean.DataList;

import java.util.List;

/**
 * @author lianghaimiao
 * @date 2019/3/1
 * @function
 */

class MyAdapter extends RecyclerView.Adapter<MyViewHolder>  {
    private final List<DataList> mList;

    public MyAdapter(List<DataList> list) {

        this.mList = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_main, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int i) {
        holder.item_tv.setText(mList.get(i).name);
        holder.item_tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //自定义的ViewHolder，持有每个Item的的所有界面元素

        public Button item_tv;

        public MyViewHolder(View view) {
            super(view);
            item_tv = view.findViewById(R.id.tv);
        }
    }


    private OnItemClickListener mOnItemClickListener;

    public void setmOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
