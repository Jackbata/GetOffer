package com.up.lhm.getoffer.animator.recycleview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.animator.recycleview.Nightadapter.ItemClickListener;
import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.hmtools.system.IntentUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author lianghaimiao
 * @date 2019/3/31
 * @function
 */

public class AnReaycleActivity extends BaseActivity {


  private Nightadapter nightadapter;
  private RecyclerView rv_night;
  private ArrayList<NightBean> list;

  public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, AnReaycleActivity.class, finishSelf, args);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.animator_recycle_layout;
    }

    @SuppressLint("WrongConstant")
    @Override
    public void initData() {

      list = new ArrayList<>();
        for (int i = 0; i <25 ; i++) {
          if (i==12)continue;
            NightBean nightBean = new NightBean();
            nightBean.num=i+"";
            list.add(nightBean);
        }
      NightBean nightBean = new NightBean();
      nightBean.num="-1";
      list.add(12,nightBean);

       rv_night = findViewById(R.id.rv_night);
      GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5);
      gridLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
      rv_night.setLayoutManager(gridLayoutManager );
      nightadapter = new Nightadapter(this, list);
      rv_night.setAdapter(nightadapter);
      nightadapter.setOnItemClickListener(new ItemClickListener(){

        @Override
        public void onItemClick(NightBean nightBean) {
          nightBean.isAnimator=true;
          nightadapter.notifyItemChanged(nightBean.position);
        }
      });

      findViewById(R.id.bt_night_start).setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
          for (int i = 0; i <5 ; i++) {
            list.get(i).isAnimator=true;
          }

          nightadapter.notifyItemRangeChanged(0,5,"iv");
        }
      });
    }
}
