class Solution {
    public int countBinarySubstrings(String s) {
    	int n = s.length();
    	if(s.charAt(n-1)=='0')
    		s = s+"1";
    	else
    		s = s+"0";
        int sw = 0;
        int head = s.charAt(0)-'0';
        int prelen = 0;
        int len = 0;
        int ans = 0;
        for(int i=1;i<s.length();i++){
        	int cur = s.charAt(i)-'0';
        	if(head==1-cur){
        		prelen = len;
        		len = i-sw;        		
        		sw = i;
        		head = cur;
        		ans+=Math.min(prelen,len);
        	}
        }
        return ans;
    }
}