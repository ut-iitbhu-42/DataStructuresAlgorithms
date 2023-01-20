package com.dsa.dp.fibonacci;

import java.util.Scanner;

public class BottomToTopDP {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fibonacci(n));
    }

    // Bottom to Top Approach
    // First calculate Base-problems(here, for n=0 & 1), calculate parent prob using these base-results
    // reduces time complexity to O(n), because only 1 time we have to calculate a sub-problem solution
    static int fibonacci(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        int dp[] = new int[n+1];   // used for memoization

        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
