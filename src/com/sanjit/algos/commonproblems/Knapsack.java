package com.sanjit.algos.commonproblems;

// A Dynamic Programming based solution
// for 0-1 Knapsack problem
/**
 * Let weight elements = {1, 2, 3}
 * Let weight values = {10, 15, 40}
 * Capacity=6
 *
 * 0   1   2   3   4   5   6
 *
 * 0  0   0   0   0   0   0   0
 *
 * 1  0  10  10  10  10  10  10
 *
 * 2  0  10  15  25  25  25  25
 *
 * 3  0
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

    // A utility function that returns
    // maximum of two integers
    static int max(int a, int b)
    {
        return (a > b) ? a : b;
    }

    // Returns the maximum value that can
    // be put in a knapsack of capacity W
    static int knapSack(int W, int wt[],
                        int val[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w]
                            = max(val[i - 1]
                                    + K[i - 1][w - wt[i - 1]],
                            K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }

    // Driver code
    public static void main(String args[])
    {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}