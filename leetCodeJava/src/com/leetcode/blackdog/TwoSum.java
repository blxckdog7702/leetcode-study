package com.leetcode.blackdog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{15, 11, 7, 2};
        int target = 9;

        TwoSum main = new TwoSum();
        System.out.println(Arrays.toString(main.twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if(map.containsKey(diff)) {
                int[] result = {map.get(diff), i};
                return result;
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }
}
