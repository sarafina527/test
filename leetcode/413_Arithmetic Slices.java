class Solution {
    public int numberOfArithmeticSlices(int[] A) {
    	if(A.length<3) return 0;
        int delta = A[1]-A[0],s=0;
        int ans = 0;
        for(int i=1;i<A.length;i++){
        	if(i+1==A.length||A[i+1]-A[i]!=delta){
        		int len = i-s+1;
        		s = i;        		
        		if(len>=3){
        			ans +=(len-2)*(len-1)/2;
        		}
        		if(i+1<A.length)
        			delta = A[i+1]-A[i];
        	}
        }
        return ans;
    }
}