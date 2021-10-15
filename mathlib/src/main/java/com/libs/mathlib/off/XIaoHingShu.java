package com.libs.mathlib.off;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/10/14 4:22 PM
 */
public class XIaoHingShu {

  public void testxhs() {
    int[][] arr = {{-1, 3}};
    boolean tagert = getTagert(arr, 3);
    System.out.println(tagert);
  }

  /**
   * 1，2，4，6，8
   * <p>
   * 3，5，8，10，11
   * <p>
   * 5，7，9，15，19
   * <p>
   * left -> right  up
   * <p>
   * top -> down up
   * <p>
   * int[][] nums
   * <p>
   * int target
   * <p>
   * return boolean 判断指定值是否存在于二维数组
   *
   * @param nums
   * @param target
   * @return
   */
  public boolean getTagert(int[][] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      int[] arr = nums[i];
      for (int j = 0; j < arr.length; j++) {
        if (target == arr[j]) {
          return true;
        }
      }
    }

    return false;
  }

  public boolean binarySearch(int[] arr, int target) {
    int length = arr.length - 1;
    int lo = 0;
    int hi = length;

    while (lo <= hi) {
      int mid = (lo + hi) >>> 1;
      if (arr[mid] < target) {
        lo = mid + 1;
      } else if (arr[mid] > target) {
        hi = mid - 1;
      } else {
        return true;
      }
    }
    return false;
  }
  class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      // start our "pointer" in the bottom-left
      int row = matrix.length-1;
      int col = 0;

      while (row >= 0 && col < matrix[0].length) {
        if (matrix[row][col] > target) {
          row--;
        } else if (matrix[row][col] < target) {
          col++;
        } else { // found it
          return true;
        }
      }

      return false;
    }
  }


}
