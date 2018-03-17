/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        int[] ans = new int[intervals.length];
        HashMap<Integer,Integer> startpos = new HashMap<Integer,Integer>();
        int[] starts = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
        	startpos.put(intervals[i].start,i);
        	starts[i] = intervals[i].start;
        }
        Arrays.sort(starts);
        for(int i=0;i<intervals.length;i++){
        	int s = bsearchFirstbe(intervals[i].end,starts);
        	if(s==-1) ans[i] = -1;
        	else ans[i] = startpos.get(starts[s]);
        }
        return ans;
    }
    public int bsearchFirstbe(int t,int[] x){
    	int l=0,u=x.length-1;
    	while(l<=u){
    		int mid = l+(u-l)/2;
    		if(x[mid]>=t&&(mid==0||x[mid-1]<t))//first bigger or equal
    			return mid;
    		else if(x[mid]<t)
    			l = mid+1;
    		else
    			u = mid-1;
    	}
    	return -1;
    }
}