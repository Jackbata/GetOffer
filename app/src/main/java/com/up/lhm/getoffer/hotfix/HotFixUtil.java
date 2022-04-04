package com.up.lhm.getoffer.hotfix;

import android.content.Context;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2022/4/4 1:57 PM
 */
public class HotFixUtil {

  /**
   * 热修复代码
   */
  public static void hotFix(Context context,String path){
//    File file = new File("/data/data/com.up.lhm.getoffer/hot.dex");
    File file = new File(getAssetsCacheFile(context,path));
    if (!file.exists()){
      Log.d("hotFix", "hotFix: 不需要热修复");
      return;
    }

    try {
      Field pathListField = BaseDexClassLoader.class.getDeclaredField("pathList");
      pathListField.setAccessible(true);
      Object pathList = pathListField.get(context.getClassLoader());

      Class<?> pathListObject = pathList.getClass();
      Field dexElementsField = pathListObject.getDeclaredField("dexElements");
      dexElementsField.setAccessible(true);
      Object dexElementsObject = dexElementsField.get(pathList);

      DexClassLoader dexClassLoader = new DexClassLoader(file.getPath(),
          context.getCacheDir().getAbsolutePath(), null, context.getClassLoader());
      Object newPathListField = pathListField.get(dexClassLoader);
      Object newDexElementsObject = dexElementsField.get(newPathListField);


      int oldLength= Array.getLength(dexElementsObject);
      int newLength= Array.getLength(newDexElementsObject);

      Object hotfixDexElementsObject = Array.newInstance(dexElementsObject.getClass().getComponentType(),oldLength+newLength);

      for (int i = 0; i < newLength; i++) {
        Array.set(hotfixDexElementsObject,i,Array.get(newDexElementsObject,i));
      }
      for (int i = 0; i <oldLength; i++) {
        Array.set(hotfixDexElementsObject,i+newLength,Array.get(dexElementsObject,i));
      }


      dexElementsField.set(pathList,hotfixDexElementsObject);
      Log.d("hotFix", "hotFix: 热修复完成");

//            file.delete();
    } catch (IllegalAccessException | NoSuchFieldException e) {
      e.printStackTrace();
      Log.d("hotFix", "修复异常"+e.getMessage());

    }

  }

  /**
   * path包暂存到assets文件夹下
   * @param context
   * @param fileName
   * @return
   */
  public static String getAssetsCacheFile(Context context, String fileName)   {
    File cacheFile = new File(context.getCacheDir(), fileName);
    try {
      InputStream inputStream = context.getAssets().open(fileName);
      try {
        FileOutputStream outputStream = new FileOutputStream(cacheFile);
        try {
          byte[] buf = new byte[1024];
          int len;
          while ((len = inputStream.read(buf)) > 0) {
            outputStream.write(buf, 0, len);
          }
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          outputStream.close();
        }
      } finally {
        inputStream.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return cacheFile.getAbsolutePath();
  }
}
