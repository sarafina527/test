public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
    	Arrays.sort(houses);
    	Arrays.sort(heaters);
    	int ans = Integer.MIN_VALUE;
        for(int i=0;i<houses.length;i++){
        	int found = findPreHeater(heaters,houses[i]);
        	int preRad = found>=0?houses[i]-heaters[found]:Integer.MAX_VALUE;
        	int postRad = found+1<heaters.length?heaters[found+1]-houses[i]:Integer.MAX_VALUE;
        	int min = preRad<postRad?preRad:postRad;
        	if(min>ans) ans = min;
        }
        return ans;
    }
    public int findPreHeater(int[] heaters,int h){
    	int p=0,q=heaters.length-1;
    	while(p<=q){
    		int m = p+(q-p)/2;
    		if(heaters[m]<=h&&(m+1==heaters.length||m+1<heaters.length&&heaters[m+1]>h)){
    			return m;
    		}else if(heaters[m]>h){
    			q = m-1;
    		}else{
    			p = m+1;
    		}
    	}
    	return -1;
    }
}