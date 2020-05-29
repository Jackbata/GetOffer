package com.up.lhm.getoffer.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.up.lhm.getoffer.R;

import java.util.List;

import butterknife.BindFloat;

/**
 * @author barry
 * @date 2020/5/29
 * @function
 */

public class MyListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Integer> mlist;

    public MyListAdapter(Context context, List<Integer> list){
        this.mContext=context;
        this.mlist=list;
    }
    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         ViewHolder mHolder = null;

        if (convertView==null){
             mHolder = new ViewHolder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.item_list, null);
            mHolder.iv_pic  = convertView.findViewById(R.id.iv);
            convertView.setTag(mHolder);
        }else {
             mHolder = (ViewHolder) convertView.getTag();

        }
        mHolder.iv_pic.setImageDrawable(mContext.getResources().getDrawable(mlist.get(position)) );
        return convertView;
    }

    static class ViewHolder {
        ImageView iv_pic;
    }
}
