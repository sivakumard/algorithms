package com.cisan.data_structure.array.dynamic_programming;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("fibonacci: " + fibonacci.fib(9));
    }

    private int fib(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;
        for(int i = 2; i <= n; i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    }
}
