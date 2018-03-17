class Solution {
    public boolean isMatch(String s, String p) {
        int m=p.length(),n=s.length();
        boolean[][] dp = new boolean[m+1][n+1];//p[i] s[j] behind match
        dp[m][n] = true;
        int i;
        for(i=m-1;i>=0&&p.charAt(i)=='*';i--){
            for(int j=0;j<=n;j++)
                dp[i][j] = true;
        }
        for(;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(p.charAt(i)=='?'||p.charAt(i)==s.charAt(j))
                    dp[i][j] = dp[i+1][j+1];
                else if(p.charAt(i)=='*')
                    dp[i][j] = dp[i][j+1]||dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}