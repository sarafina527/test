public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len+1][m+1][n+1];
        for(int l=0;l<len;l++){
            for(int i=1;i<=m;i++)
                for(int j=1;j<=n;j++)
                    dp[l][i][j] = -1;            
        }
        for(int l=len-1;l>=0;l--){
            int nz = zeroNums(strs[l]);
            int no = strs[l].length()-nz;
            for(int i=0;i<=m;i++){
                for(int j=0;j<=n;j++){
                    dp[l][i][j] = dp[l+1][i][j];
                    if(i>=nz&&j>=no)
                        dp[l][i][j] = Math.max(dp[l][i][j],1+dp[l+1][i-nz][j-no]);
                }
            }
        }
        return dp[0][m][n];
    }
    public static int zeroNums(String str){
        int ans=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0')
                ans++;
        }
        return ans;
    }
}

    public int findMaxForm(String[] strs,int l,int m,int n,int[][][] dp){
        if(l>=strs.length) return 0;
        if(dp[l][m][n]>=0) return dp[l][m][n];
        int nz = zeroNums(strs[l]);
        int no = strs[l].length()-nz;
        if(m>=nz&&n>=no){
            dp[l][m][n] = Math.max(findMaxForm(strs,l+1,m,n,dp),1+findMaxForm(strs,l+1,m-nz,n-no,dp));
        }
        return dp[l][m][n];
    }


        // for(int i=0;i<strs.)
     //    Arrays.sort(strs,new Comparator<String>(){
     //     int compare(String s1,String s2){
     //         return  new Integer(s1.length()).compareTo(s2.length());
     //     }
     //    });
// for(int i=0;i<strs.length;i++){
//             int zcnt = zeroNums(strs[i]),ocnt = strs[i].length()-zcnt;
//             for(int j=)
//         }