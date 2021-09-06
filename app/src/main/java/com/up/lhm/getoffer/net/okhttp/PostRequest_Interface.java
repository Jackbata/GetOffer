package com.up.lhm.getoffer.net.okhttp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/8/6 5:23 PM
 */
public interface PostRequest_Interface {
  @POST("translate?doctype=json&jsonversion=&type=&keyfrom=&model=&mid=&imei=&vendor=&screen=&ssid=&network=&abtest=")
  @FormUrlEncoded
  Call<Translation1> getCall(@Field("i") String targetSentence);

  Translation1 getCall2(@Field("i") String targetSentence);
  //采用@Post表示Post方法进行请求（传入部分url地址）
  // 采用@FormUrlEncoded注解的原因:API规定采用请求格式x-www-form-urlencoded,即表单形式
  // 需要配合@Field 向服务器提交需要的字段
}
