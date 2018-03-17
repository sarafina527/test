class Solution {
    public int minSteps(int n) {
        int[] steps = new int[n+1];
        Arrays.fill(steps,Integer.MAX_VALUE);
        steps[1] = 0;
        for(int i=2;i<=n;i++){
        	for(int j=1;j<i;j++){
        		if(i%j==0){
        			steps[i] = Math.min(steps[i],steps[j]+i/j);
        		}
        	}
        }
        return steps[n];
    }
}