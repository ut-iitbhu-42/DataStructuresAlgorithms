package com.dsa.dp.minCoins;

public class RecursiveApproach {

    public static void main(String args[]) {
        int n = 18;
        int coins[] = {1, 5, 7};
        // correct ans = 4

        System.out.println(minCoins(n, coins));
    }

    // Recursive approach
    // it will take (NO_OF_Coins power n) time
    static int minCoins(int n, int coins[]){
        int ans = Integer.MAX_VALUE;

        if(n==0) return 0;

        for(int coin : coins){
            if(n-coin >= 0){
                int subAns = 1 + minCoins(n-coin, coins);
                if(ans > subAns)
                    ans = subAns;
            }
        }
        return ans;
    }
}
