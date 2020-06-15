package com.leetcode.blackdog;

public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(new int[] {1,3,5,6}, 5));
        System.out.println(searchInsertPosition.searchInsert(new int[] {1,3,5,6}, 2));
        System.out.println(searchInsertPosition.searchInsert(new int[] {1,3,5,6}, 7));
        System.out.println(searchInsertPosition.searchInsert(new int[] {1,3,5,6}, 0));
        System.out.println(searchInsertPosition.searchInsert(new int[] {1}, 1));
    }

    public int searchInsert(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        int mid = (min + max) / 2;

        if(nums[min] > target) {
            return 0;
        }

        if(nums[max] < target) {
            return nums.length;
        }

        while(min != max) {
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if(mid - 1 >= 0 && nums[mid - 1] < target) {
                    return mid;
                }
                max = mid - 1;
            } else {
                if(mid + 1 < nums.length && nums[mid + 1] > target) {
                    return mid + 1;
                }
                min = mid + 1;
            }

            mid = (min + max) / 2;
        }

        return mid;
    }
}
