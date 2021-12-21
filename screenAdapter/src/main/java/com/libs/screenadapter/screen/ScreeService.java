package com.libs.screenadapter.screen;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.libs.commonlib.BaseService;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/12/21 11:54 AM
 */
@Route(path ="/screen/ScreeService" )
public class ScreeService implements BaseService {

  @Override
  public int getDa() {
    return 223;
  }


  @Override
  public void init(Context context) {

  }
}
