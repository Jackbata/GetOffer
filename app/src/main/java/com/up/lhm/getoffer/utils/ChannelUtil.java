package com.up.lhm.getoffer.utils;

import android.content.Context;
import com.meituan.android.walle.ChannelInfo;
import com.meituan.android.walle.WalleChannelReader;
import java.util.Map;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/6/30 2:22 PM
 */
public class ChannelUtil {


  public static String getChannelName(Context context){
    if(context == null){
      return "";
    }
    return WalleChannelReader.getChannel(context,"");
  }


  public static String getExtraInfo(Context context,String key){
    if(context == null){
      return "";
    }
    ChannelInfo channelInfo= WalleChannelReader.getChannelInfo(context.getApplicationContext());
    if (channelInfo != null) {
      //如果要获取渠道
      //String channel = channelInfo.getChannel();
      Map<String, String> extraInfo = channelInfo.getExtraInfo();
      return extraInfo.get(key);
    }else {
      return "";
    }
    // 或者也可以直接根据key获取
    //return WalleChannelReader.get(context, key);
  }
}
