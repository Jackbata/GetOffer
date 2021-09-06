package com.libs.mathlib.letc.hot;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description: 两数之和 https://leetcode-cn.com/problems/two-sum/
 * @Author: 肖邦
 * @CreateDate: 2021/9/6 11:07 AM
 */
public class _1_TwoSum {

  public int[] twoSum(int[] nums, int target) {

//    int[] ints = new int[2];
//    for (int i = 0; i < nums.length; i++) {
//      int temp = nums[i];
//      for (int j = i+1; j < nums.length; j++) {
//           if (temp+nums[j]==target){
//             ints[0]=i;
//             ints[1]=j;
//             return ints;
//           }
//      }
//    }
//    return ints;

    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int temp = target - nums[i];
      if (hashMap.containsKey(temp)){
        return new int[]{hashMap.get(temp),i};
      }
      hashMap.put(nums[i],i);
    }
    return new int[0];
//

  }
}
