package com.algos.commonproblems;

import java.util.*;

public class BackTrackExamples {
    static void permute(String s , String answer)
    {
        if(s.length() == 0)
        {
            System.out.println(answer + " ");
        }

        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i+1);
            String total = left+right;
            permute(total, answer+s.charAt(i));
        }
    }

    // Driver code
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);

        String s;
        String answer="";
        s = "ABC";

        System.out.print("\nAll possible strings are : ");
        permute(s, answer);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
