class Solution {
    int[] dp = null ;
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        dp = new int[n+1];
        for(int i=0; i<n+1; i++)
            dp[i] = -1;
        dp[0] = 0;
        dp[1] = 1;
        return recursion(n);
    }

    public int recursion(int n){
        if(dp[n]!=-1){
            return dp[n];
        }
        return recursion(n-1) + recursion(n-2);
    }

}