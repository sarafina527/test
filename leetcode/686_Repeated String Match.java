class Solution {
    public int repeatedStringMatch(String A, String B) {
        int ans = -1;
        int lena = A.length();
        if(B.indexOf(A)!=-1) return 1;
        for(int i=0;i<lena;i++){
        	if(A.charAt(i)==B.charAt(0)){
        		int j=1;
        		int ai = (i+j)%lena;
        		for(;j<B.length();j++){
        			ai = (i+j)%lena;
        			if(A.charAt(ai)!=B.charAt(j))
        				break;
        		}
        		if(j==B.length()){
        			ans = (i+j+lena-ai-1)/lena;
                    break;
        		}
        	}
        }
        return ans;
    }
}