package com.libs.mathlib.letc.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 四数之和 https://leetcode-cn.com/problems/4sum/
 * @Author: 肖邦
 * @CreateDate: 2021/9/6 1:05 PM
 */
public class _18_fourSum {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> lists = new ArrayList<>();
    if (nums==null ||nums.length<=3) return lists;
    Arrays.sort(nums);

    for (int i = 0; i <nums.length-3 ; i++) {

      if (i>0&& nums[i]==nums[i-1]) continue;//去重

      for (int j = i+1; j < nums.length-2; j++) {

        if (j>i+1&& nums[j]==nums[j-1]) continue;//去重

        int l = j+1;
        int r=nums.length-1;

        while (l<r){
          int sum = nums[i]+nums[j]+nums[l]+nums[r];
          if (sum==target){
            lists.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[l],nums[r])));
            while (l<r&&nums[l]==nums[l+1]) l++;//去重
            while (l<r&&nums[r]==nums[r-1]) r--;//去重
            l++;
            r--;
          }else if (sum>target){
            r--;
          }else {
            l++;
          }
        }

      }

    }

   return lists;
  }
}
