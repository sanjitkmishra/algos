package com.algos.commonproblems;

import java.util.HashMap;
import java.util.*;

public class SubArraySum {
    public static int findSubarraySum(int[] arr, int n, int sum)
    {
        Map<Integer, Integer> prevSum = new HashMap<>();
        int count = 0;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            // Check If currentSum is result then increase count by 1
            if(currentSum == sum)
            {
                count++;
            }

            // Check if difference between currentSum and sum is available in some subArray
            // already, if available increment the count by no of such subArray available
            if(prevSum.containsKey(currentSum - sum))
            {
                count = count + prevSum.get(currentSum - sum);
            }

            // Check if the current sum is added available in the map.
            // If not available then just add the same
            // else add by increasing the count.
            Integer res = prevSum.get(currentSum);
            if(res == null)
            {
                prevSum.put(currentSum, 1);
            }
            else
            {
                prevSum.put(currentSum, res + 1);
            }


        }

        return count;
    }
    public static void main(String[] args)
    {
        int arr[] = { 10, 2, -2, -20, -10 };
        int sum = 0;
        int n = arr.length;
        System.out.println(findSubarraySum(arr, n, sum));
    }
}
