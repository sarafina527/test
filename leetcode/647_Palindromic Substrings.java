class Solution {
    public int countSubstrings(String s) {
    	int n = s.length();
        boolean[][] isPa = new boolean[n][n];
        int ans = 0;
        for(int i=0;i<n;i++){
        	isPa[i][i] = true;
        }
        for(int i=0;i<n-1;i++){
        	if(s.charAt(i)==s.charAt(i+1))
        		isPa[i][i+1] = true;
        }
        for(int l=3;l<=n;l++){
        	for(int i=0;i+l<=n;i++){
        		if(isPa[i+1][i+l-2]&&(s.charAt(i)==s.charAt(i+l-1)))
        			isPa[i][i+l-1] = true;
        	}
        }
        for(int i=0;i<n;i++){
        	for(int j=0;j<n;j++){
        		if(isPa[i][j])
        			ans++;
        	}
        }
        return ans;
    }
}