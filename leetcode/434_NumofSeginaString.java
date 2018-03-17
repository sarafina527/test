public class Solution {
    public int countSegments(String s) {
    	int ans = 0;
        String[] strs = s.split("\\s+");
        for(int i=0;i<strs.length;i++){
        	if(strs[i].length()>0)
        		ans++;
        }
        return ans;
    }
}