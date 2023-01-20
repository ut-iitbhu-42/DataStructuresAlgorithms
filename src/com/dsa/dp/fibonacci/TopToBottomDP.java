package com.dsa.dp.fibonacci;

import java.util.Scanner;

public class TopToBottomDP {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fibonacci(n));
    }

    static int fibonacci(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        int dp[] = new int[n+1];   // used for memoization
        return fib(n, dp);
    }

    // Top to Bottom Approach
    // To calculate bigger prob, we are dependent on two subproblems fib(n-1) & fib(n-2)
    // if subprob in already calculated, it is CACHED in an array(memoisation)
    // reduces time complexity to O(n), because only 1 time we have to calculate a sub-problem solution
    // IMP: in some cases, subproblem space overlaps, we also need to keep that in our mind
    static int fib(int n, int dp[]){
        if(n==0) return 0;
        if(n==1) return 1;
        if(dp[n]==0){
            dp[n] = fib(n-1, dp) + fib(n-2, dp);
        }
        return dp[n];
    }
}
