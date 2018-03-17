class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        long sum = 0;
        int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
        
        for(int elem:nums){
        	sum+=elem;
        	if(elem>max)
        		max = elem;
        	if(elem<min)
        		min = elem;
        }
        for(int e=max;;e++){
        	long diff = (long)n*e-sum;
        	if(diff%(n-1)==0&&(diff/(n-1)>=e-min))
        		return (int)(diff/(n-1));
        }
    }
}