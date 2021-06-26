package com.algos.commonproblems;

// A Dynamic Programming based solution
// for 0-1 Knapsack problem
/**
 * Let weight elements = {1, 2, 3}
 * Let weight values = {10, 15, 40}
 * Capacity=6
 *
 * 0   1   2   3   4   5   6
 *
 * 0   0   0   0   0   0   0   0
 *
 * 1   0  10  10  10  10  10  10
 *
 * 2   0  10  15  25  25  25  25
 *
 * 3   0
 *
 * Explanation:
 * For filling 'weight = 2' we come
 * across 'j = 3' in which
 * we take maximum of
 * (10, 15 + DP[1][3-2]) = 25
 *   |        |
 * '2'       '2 filled'
 * not filled
 *
 * 0   1   2   3   4   5   6
 *
 * 0  0   0   0   0   0   0   0
 *
 * 1  0  10  10  10  10  10  10
 *
 * 2  0  10  15  25  25  25  25
 *
 * 3  0  10  15  40  50  55  65
 *
 * Explanation:
 * For filling 'weight=3',
 * we come across 'j=4' in which
 * we take maximum of (25, 40 + DP[2][4-3])
 * = 50
 *
 * For filling 'weight=3'
 * we come across 'j=5' in which
 * we take maximum of (25, 40 + DP[2][5-3])
 * = 55
 *
 * For filling 'weight=3'
 * we come across 'j=6' in which
 * we take maximum of (25, 40 + DP[2][6-3])
 * = 65
 */
class Knapsack {
    // Returns the maximum value that can
    // be put in a knapsack of capacity capacity
    static int knapSack(int capacity, int wt[], int val[], int n)
    {
        int dp[][] = new int[n + 1][capacity + 1];

        // Build table dp[][] in bottom up manner
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= capacity; j++)
            {
                if (i == 0 || j == 0)
                {
                    dp[i][j] = 0;
                }
                else if (wt[i - 1] <= j)
                {
                    int currentMax = val[i - 1] + dp[i - 1][j - wt[i - 1]];
                    dp[i][j] = Math.max(currentMax, dp[i - 1][j]);
                }
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][capacity];
    }

    // Driver code
    public static void main(String args[])
    {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int capacity = 50;
        int n = val.length;
        System.out.println(knapSack(capacity, wt, val, n));
    }
}