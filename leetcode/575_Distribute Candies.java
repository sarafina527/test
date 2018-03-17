class Solution {
    public int distributeCandies(int[] candies) {
        int n = candies.length;
        Set<Integer> kinds = new HashSet<Integer>();
        for(int e:candies){
        	if(!kinds.contains(e))
        		kinds.add(e);
        }
        return Math.min(kinds.size(),n/2);
    }
}