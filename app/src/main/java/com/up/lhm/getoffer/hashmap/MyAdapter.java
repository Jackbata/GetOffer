package com.up.lhm.getoffer.hashmap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.up.lhm.getoffer.R;

/**
 * @author lianghaimiao
 * @date 2019/3/30
 * @function
 */

class MyAdapter extends BaseAdapter {
    private final String[] data;
    private final Context mContext;

    public MyAdapter(String[] data, Context context) {
        this.mContext = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.view_item, null);

            holder = new ViewHolder();
            holder.btn = convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.btn.setText(data[position]);
        return convertView;
    }


    static class ViewHolder {
        Button btn;
    }
}
