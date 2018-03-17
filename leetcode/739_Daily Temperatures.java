class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> indexStack = new LinkedList<Integer>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
        	while(!indexStack.isEmpty()&&temperatures[indexStack.peek()]<=temperatures[i]){
        		indexStack.pop();
        	}
        	if(indexStack.isEmpty()){
        		ans[i] = 0;
        	}else{
        		ans[i] = indexStack.peek()-i;
        	}
        	indexStack.push(i);
        }
        return ans;
    }
}