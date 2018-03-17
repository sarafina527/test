public class Solution {
    public int numberOfBoomerangs(int[][] points) {
    	int ans = 0;
        HashMap<Integer,Integer> record = new HashMap<Integer,Integer>();
        for(int i=0;i<points.length;i++){
        	record.clear();
        	for(int j=0;j<points.length;j++){
        		if(i==j) continue;
        		int distsq = (points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
        		if(!record.containsKey(distsq))
        			record.put(distsq,1);
        		else{
        		    int val = record.get(distsq);
        			record.put(distsq,val+1);
        		}
        	}
        	for(int e:record.values()){
        		ans += e*(e-1);
        	}
        }
        return ans;
    }
}