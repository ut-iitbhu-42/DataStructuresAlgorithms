package com.dsa.dp.fibonacci;

import java.util.Scanner;

public class RecursiveApproach {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fibonacci(n));
    }

    // Recursive approach without optimisation => take O(2 power n) time complexity
    static int fibonacci(int n){
        if(n==0) return 0;
        if (n==1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
