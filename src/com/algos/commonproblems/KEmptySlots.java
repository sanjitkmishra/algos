package com.algos.commonproblems;

import java.util.HashMap;
import java.util.Map;

public class KEmptySlots {
    public static void main(String[] args) {
        int[] flowers = new int[]{1, 3, 4, 2};
        int k = 1;
        System.out.println(kEmptyShort(flowers,k));
    }

    public static int kEmptyShort(int[] flowers, int k)
    {
        int[] position = new int[flowers.length];
        /**
         * 0 - 1
         * 1 - 3
         * 2 - 2
         */
        for (int i = 0; i < flowers.length; i++) {
            position[flowers[i]-1] = i+1;
        }

        int left = 0;
        int right = k+1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; right < position.length; i++) {
            if(position[i] > position[left] && position[i] > position[right])
            {
                continue;
            }
            if(i == right)
            {
                result = Math.min(result, Math.max(position[left], position[right]));
            }
            left = i;
            right = i+k+1;
        }
        return result;
    }
}
