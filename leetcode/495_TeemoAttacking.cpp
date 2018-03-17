public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length<=0) return 0;
        int curmax = timeSeries[0]+duration-1;
        int ans = duration;
        for(int i=1;i<timeSeries.length;i++){
        	int start = timeSeries[i];
        	if(start+duration-1>=curmax){
        		if(start>curmax)
        			ans+=duration;
        		else
        			ans+=(duration-curmax+start-1);
        		
        		curmax = start+duration-1;
        	}        	
        }
        return ans;
    }
}