class Solution {
    public boolean isMatch(String s, String p) {
        int m=p.length(),n=s.length();
        boolean[][] dp = new boolean[m+1][n+1];//p[i] s[j] behind match
        dp[m][n] = true;
        int mm = m-1;
        for(;mm>=0&&p.charAt(mm)=='*';mm--){
            mm--;
            for(int j=n-1;j>=0&&(p.charAt(mm)=='.'||s.charAt(j)==p.charAt(mm));j--)
                dp[mm][j] = true;
        }
        
        for(int j=n-1;j>=0;j--){
            for(int i=mm;i>=0;i--){
                if(p.charAt(i)=='.'||p.charAt(i)==s.charAt(j))
                    dp[i][j] = dp[i+1][j+1];
                else if(p.charAt(i)=='*'&&i>=1){
                    //System.out.println(i+" "+j+" "+p.charAt(i)+" "+dp[i-1][j+1]+dp[i+1][j]);
                    if(p.charAt(i-1)=='.'||p.charAt(i-1)==s.charAt(j))
                        dp[i-1][j] = dp[i-1][j+1]||dp[i+1][j];//yige char he 0ge
                    else
                        dp[i-1][j] = dp[i+1][j];
                    i--;
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[0][0];
    }
}