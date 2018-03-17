class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
    	int n = A.length;
    	assert(B.length==n);
        Map<Integer,LinkedList<Integer> > bmap = new HashMap<Integer,LinkedList<Integer> >();
        for(int i=0;i<n;i++){
        	if(bmap.containsKey(B[i])){
        		bmap.get(B[i]).add(i);
        	}else{
        		LinkedList<Integer> indices = new LinkedList<Integer>();
        		indices.add(i);
        		bmap.put(B[i],indices);
        	}
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
        	if(bmap.containsKey(A[i])){
        		LinkedList<Integer> indices = bmap.get(A[i]);
        		if(!indices.isEmpty()){
        			int index = indices.poll();
        			ans[i] = index;
        		}        		
        	}
        }
        return ans;        
    }
}
