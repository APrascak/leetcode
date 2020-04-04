// Fibonacci Number
// 4 April 2020

class Solution {
    public int fib(int N) {
        return calcFib(N, new int[N+1]);
    }
    
    public static int calcFib(int n, int[] arr) {
        if (n == 1 || n == 0) return n;
        if (arr[n] != 0) return arr[n];
        arr[n] = calcFib(n-1, arr) + calcFib(n-2, arr);
        return arr[n];
    }
}