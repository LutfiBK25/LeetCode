package com.leetCode.twoSums;
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int nums[] = {3, 2, 4};
        int target = 6;

        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSumSolution_Brute_Force(nums, target)));
        System.out.println(Arrays.toString(twoSumSolution_Hash_Table(nums, target)));
        System.out.println(Arrays.toString(twoSum_Hash_Table_One_Pass(nums, target)));

    }

    private static int[] twoSum(int[] nums, int target) {
        int array [] = new int[2];
        for (int i = 0; i <= nums.length -1; i++){
            for (int j = 1; j <= nums.length -1; j++) {
                if (nums[i] + nums[j] == target && i != j){
                    array[0] = i;
                    array[1] = j;
                    return array;
                }
            }
        }
        return array;
    }

    //this the solution using O(n^2)
    //Brute Force

    public static int[] twoSumSolution_Brute_Force(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // No solution found
    }

    //the next 2 solutuions are O(n)
    //two-pass Hash table
    public static int[] twoSumSolution_Hash_Table(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        // Build the hash table
        for (int i = 0; i < n; i++) {
            numMap.put(nums[i], i);
        }

        // Find the complement
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement) != i) {
                return new int[]{i, numMap.get(complement)};
            }
        }

        return new int[]{}; // No solution found
    }

    //one pass hash table

    public static int[] twoSum_Hash_Table_One_Pass(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{}; // No solution found
    }

}



