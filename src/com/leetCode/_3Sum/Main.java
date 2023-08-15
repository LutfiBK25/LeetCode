package com.leetCode._3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = 1; j < nums.length - 1; j++) {
                for (int k = 2; k < nums.length; k++) {
                    if (k > 0 && nums[i] == nums[k - 1]) continue;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        if (i != k && i != j && j != k)
                            if(nums[j]!= nums[k])
                            System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    }
                }
            }
        }
        return ans;
    }

}
