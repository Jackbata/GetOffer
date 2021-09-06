package com.libs.mathlib.letc.hot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Description: 三数之和 https://leetcode-cn.com/problems/3sum/
 * @Author: 肖邦
 * @CreateDate: 2021/9/6 11:34 AM
 * 解析：https://leetcode-cn.com/problems/3sum/solution/yi-miao-jiu-neng-kan-dong-de-dong-tu-jie-unfp/
 */
public class _15_ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
      if (nums==null||nums.length<=2) return lists;

       Arrays.sort(nums);//排序后方便去重

       if (nums[0]>0) return lists;//首元素大于0，不存在和等于0的元素

     for (int i = 0; i < nums.length-2; i++) {

      if (i>0&&nums[i]==nums[i-1]) continue;//去除重复三数和

      int l=i+1;
      int r = nums.length-1;

      while(l<r){
        int sum = nums[i]+nums[l]+nums[r];
        if (sum==0){
          lists.add(new ArrayList<>(Arrays.asList(nums[i],nums[l],nums[r])));

          while (l<r&&nums[l]==nums[l+1]) l++;//去除重复三数和
          while (l<r&&nums[r]==nums[r-1]) r--;//去除重复三数和
          l++;
          r--;
        }else if (sum>0){
          l++;
        }else {
          r--;
        }
      }

    }

      return lists;
  }
}
