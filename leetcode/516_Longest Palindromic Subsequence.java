public class Solution {
    public int longestPalindromeSubseq(String s) {
    	int n = s.length();
        if(n==0) return 0;
        int[][] d = new int[n][n];
        for(int i=n-1;i>=0;i--){
        	for(int j=i;j<n;j++){
        		if(s.charAt(i)==s.charAt(j))
        		{
        			if(i==j) d[i][j] = 1;
        			else d[i][j] = 2+d[i+1][j-1];
        		}else{
        			d[i][j] = Math.max(d[i+1][j],d[i][j-1]);
        		}
        	}
        }
        return d[0][n-1];
    }
}