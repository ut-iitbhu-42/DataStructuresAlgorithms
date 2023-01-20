package com.dsa.dp.minCoins;

import java.util.Arrays;

public class TopToBottomDP {

    public static void main(String args[]) {
        int n = 18;
        int coins[] = {7,5,1};
        // correct ans = 4

        int dp[] = new int[n+1];  // used to DP memoization
        Arrays.fill(dp, -1);
        dp[0]=0;
        int minNoOfCoins = minCoins(n, coins, dp);
        System.out.println(minNoOfCoins);
        //print DP array
        for(int x: dp){
            System.out.print(x + " ");
        }
    }


    // time complexity = O(m.n)  |  space complexity = O(n)
    // m -> no of coind
    // n -> no for which we are solving prob
    static int minCoins(int n, int coins[], int dp[]){
        if(n==0) return 0;

        int ans = Integer.MAX_VALUE;

        for(int coin : coins){
            if(n-coin >= 0){   // if coin can be used, follow IF-block
                int subAns;
                if(dp[n-coin] != -1){  //if subProb is solved & saved in DP-array, use it [OPTIMISATION]
                    subAns = 1 + dp[n-coin];
                } else {               //if subProb is not-solved, solve it
                    subAns = 1 + minCoins(n - coin, coins, dp);   // this tep will be optimised, since it will be called max. N-times
                }
                if(ans > subAns) {
                    ans = subAns;
                }
            }
        }
        dp[n] = ans;   // store ans in DP-array --> memoization
        return ans;
    }

}
