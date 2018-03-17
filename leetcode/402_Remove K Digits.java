class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        int s = 0;
        String ans = "";
        for(int m=0;m<n-k;m++){
        	int min = Integer.MAX_VALUE;
        	for(int i=s;i<=k+m;i++){
	        	int d = num.charAt(i)-'0';
	        	if(d<min){
	        		min = d;
	        		s = i+1;
	        	}
	        }
	        ans=ans+min;
        }
        ans = ans.replaceFirst("^0*", "");
        if(ans.length()==0)
        	ans = "0";
        return ans;        
    }
}