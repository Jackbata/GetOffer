package com.up.lhm.getoffer.arith.node;

/**
 * @author lianghaimiao
 * @date 2019/4/24
 * @function
 */

public class NodeTest {
    public static void main(String[] args) {

      int[]  nums = {-1,0,3,5,9,12};
        search(nums,9);
    }
    //        l7    l8   l9  l10
    //l  l1   l2   l3   l4   l5   l6
    //0-> 1 -> 3-> 4 -> 6 -> 2 -> 1
    //f        f1       f2        f3
    //             f4        f5
    //         f6        f7        f8
    //             f9         f10

    public static int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int middle=(high+low)>>1;

        for(int i=0;i<nums.length;i++){
            int num = nums[middle];
            if(target>num){
                low=middle+1;
                middle=(high+low)>>1;
            }else if(target<num){
                high=middle-1;
                middle=(high+low)>>1;
            } else{
                return middle;
            }

        }

        return -1;
    }
}
