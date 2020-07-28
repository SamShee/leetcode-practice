package com.kafoon.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num_1_TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 11, 15, 6, 7};
        int target = 9;

        int[] ints = twoSum(nums, target);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    private static int[] twoSum(int[] nums, int target){

        Map<Integer, Integer> temp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if(temp.containsKey(res)){
                return new int[]{temp.get(res), i};
            }else {
                temp.put(nums[i], i);
            }
        }

        return new int[0];
    }
}
