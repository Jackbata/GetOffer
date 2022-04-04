package com.libs.mathlib.off;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/10/29 9:58 AM
 */
public class ViewCount {


  public static void main(String[] args) {
    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    atomicBoolean.compareAndSet(true,false);
  }

  public ArrayList<View> getCount(View view) {
    ArrayList<View> list = new ArrayList<View>();
    int count = 0;
    if (view instanceof ViewGroup) {
      Queue<View> queue = new LinkedList<View>();
      queue.offer(view);
      list.add(view);
      count++;
      while (!queue.isEmpty()) {
        View poll = queue.poll();
        ViewGroup viewgroup = (ViewGroup) poll;
        int childCount = viewgroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
          if (view instanceof ViewGroup) {
            queue.offer(viewgroup.getChildAt(i));
          }
          list.add(viewgroup.getChildAt(i));
          count++;
        }
      }
    } else {
      count++;
      list.add(view);
    }
    return list;
  }

  public ArrayList<View> getAllView(View view) {
    ArrayList<View> list = new ArrayList();
    Queue<View> queue = new LinkedList();
    queue.add(view);
    while (!queue.isEmpty()) {
      View view1 = queue.poll();
      if (view1 instanceof ViewGroup) {
        list.add(view1);
        int childCount = ((ViewGroup) view1).getChildCount();
        for (int i = 0; i < childCount; i++) {
          View childAt = ((ViewGroup) view1).getChildAt(i);
          if (childAt instanceof ViewGroup) {
            queue.offer(childAt);
          } else {
            list.add(childAt);
          }
        }
      } else {
        list.add(view1);
      }

    }
    int count = list.size();
    return list;
  }
}
