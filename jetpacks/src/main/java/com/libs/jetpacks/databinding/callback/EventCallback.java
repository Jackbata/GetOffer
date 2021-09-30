package com.libs.jetpacks.databinding.callback;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/9/30 2:53 PM
 */
public class EventCallback {



  public void clickEvent(View view) {
    Toast.makeText( view.getContext(), "clickEvent", Toast.LENGTH_SHORT).show();
  }
}
