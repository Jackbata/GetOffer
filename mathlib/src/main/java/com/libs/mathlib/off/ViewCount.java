package com.libs.mathlib.off;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/10/29 9:58 AM
 */
public class ViewCount {


  public static void main(String[] args) {

  }

  public ArrayList<View> getCount(View view){
    ArrayList<View> list =   new ArrayList<View>();
    int count =0;
    if(view instanceof ViewGroup){
      Queue<View> queue = new LinkedList<View>();
      queue.offer(view);
      list.add(view);
      count++;
      while(!queue.isEmpty()){
        View poll = queue.poll();
          ViewGroup viewgroup = (ViewGroup) poll;
          int childCount = viewgroup.getChildCount();
          for (int i = 0; i <childCount ; i++) {
            if(view instanceof ViewGroup){
              queue.offer(viewgroup.getChildAt(i));
            }
             list.add(viewgroup.getChildAt(i));
             count++;
          }
      }
    }else {
      count++;
      list.add(view);
    }
    return list;
  }

}
