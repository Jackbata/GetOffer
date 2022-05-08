package com.up.lhm.getoffer.animator.recycleview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.up.lhm.getoffer.R;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2022/5/8 8:05 PM
 */
public class Nightadapter extends RecyclerView.Adapter<NightViewHolder> {

  ArrayList<NightBean> mList;
  private Context mContext;

  public Nightadapter(Context context, ArrayList<NightBean> list) {
    mList = list;

    mContext = context;
  }

  @NonNull
  @Override
  public NightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View inflate = LayoutInflater.from(mContext)
        .inflate(R.layout.item_recycle_night, parent, false);
    return new NightViewHolder(inflate);
  }

  @Override
  public void onBindViewHolder(@NonNull NightViewHolder holder, int position) {

  }

  @Override
  public void onBindViewHolder(@NonNull NightViewHolder holder, int position,
      @NonNull List<Object> payloads) {
    if (payloads.isEmpty()){
      NightBean nightBean = mList.get(position);
      nightBean.position=position;
      if (position==12){
        holder.tvNight.setVisibility(View.GONE);
        holder.iv_night.setVisibility(View.VISIBLE);
      }else {
        holder.tvNight.setVisibility(View.VISIBLE);
        holder.iv_night.setVisibility(View.GONE);
        holder.tvNight.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
            mItemClickListener.onItemClick(nightBean);
          }
        });
      }
    }else{
      String name = (String) payloads.get(0);
      if (name=="iv"){
        setAnimator(holder,position%5+1);
      }

    }

  }

  @Override
  public int getItemCount() {
    return mList.size();
  }

  private ItemClickListener mItemClickListener ;
  public interface ItemClickListener{
    public void onItemClick(NightBean position) ;
  }
  public void setOnItemClickListener(ItemClickListener itemClickListener){
    this.mItemClickListener = itemClickListener ;
  }



  public void setAnimator(NightViewHolder holder, int delay){
    ValueAnimator valueAnimator = new ValueAnimator().ofFloat(1,1.6f,1);
    valueAnimator.setDuration(900);
    valueAnimator.setStartDelay(delay*600);
    valueAnimator.start();
    valueAnimator.addUpdateListener(new AnimatorUpdateListener(){

      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        if (holder.iv_night.getVisibility()!=View.VISIBLE){
          holder.iv_night.setVisibility(View.VISIBLE);
          holder.tvNight.setVisibility(View.GONE);
        }
        Float animatedValue = (Float) animation.getAnimatedValue();
        holder.iv_night.setScaleX(animatedValue);
        holder.iv_night.setScaleY(animatedValue);
      }
    });
  }
}

class NightViewHolder extends ViewHolder {

  TextView tvNight;
  ImageView iv_night;

  public NightViewHolder(@NonNull View itemView) {
    super(itemView);
    tvNight = itemView.findViewById(R.id.tv_night);
    iv_night = itemView.findViewById(R.id.iv_night);

  }

}
