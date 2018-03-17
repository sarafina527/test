public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
    	if(n>10) n=10;
    	int[] dp = new int[n+1];
    	int[] fn = new int[n+1];

    	dp[1] = 10;fn[1]=9;
    	for(int i=2,j=9;i<=n;i++,j--){
            fn[i] = fn[i-1]*j;
    		dp[i] = dp[i-1]+fn[i];
            
    	}
    	return dp[n];
        
    }
}