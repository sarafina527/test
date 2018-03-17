class Solution {
    public boolean isSubsequence(String s, String t) {
    	int m = t.length(),n=s.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[m][n] = true;
        for(int i=0;i<=m;i++)
        	dp[i][n] = true;
        for(int i=m-1;i>=0;i--){
        	for(int j=n-1;j>=0;j--){
        		if(dp[i+1][j]||(t.charAt(i)==s.charAt(j)&&dp[i+1][j+1]))
        			dp[i][j] = true;
        	}
        }
        return dp[0][0];
    }
}