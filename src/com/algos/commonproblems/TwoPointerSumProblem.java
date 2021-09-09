package com.algos.commonproblems;

import java.util.Arrays;

class TwoPointerSumProblem {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3 || nums.length >  Math.pow(10,3))
        {
            return 0;
        }

        int sum = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i< nums.length && diff != 0; i++)
        {
            for(int j = i+1; j< nums.length -1 && diff != 0; j++)
            {
                int complement = target - nums[i] - nums[j];
                int index = Arrays.binarySearch(nums, j + 1, nums.length, complement);
                int hi = index >= 0 ? index : ~index;
                int lo = hi-1;

                if(hi < nums.length && Math.abs(complement - nums[hi]) < Math.abs(diff))
                {
                    diff = complement - nums[hi];
                }
                if (lo > j && Math.abs(complement - nums[lo]) < Math.abs(diff))
                {
                    diff = complement - nums[lo];
                }

            }
        }

        return target-diff;
    }
}