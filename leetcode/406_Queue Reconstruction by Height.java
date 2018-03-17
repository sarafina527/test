class Solution {
	private class pair implements Comparable<pair>{
		int h;
		int k;
		public pair(int hh,int kk){h=hh;k=kk;}
		public int compareTo(pair other){
			if(h>other.h) return -1;
			else if(h<other.h) return 1;
			else if(k<other.k) return -1;
			else if(k>other.k) return 1;
			else return 0;
		}
	}
    public int[][] reconstructQueue(int[][] people) {
    	int n = people.length;
    	pair[] ps = new pair[n];
    	int[][] ans = new int[n][2];
    	for(int i=0;i<n;i++){
    		ps[i] = new pair(people[i][0],people[i][1]);
    	}
    	Arrays.sort(ps);
    	System.out.println(Arrays.toString(ps));
    	LinkedList<pair> que = new LinkedList<pair>();
    	for(pair p:ps){
    		que.add(p.k,p);
    	}
    	for(int i=0;i<n;i++){
    		pair p = que.poll();
    		ans[i][0] = p.h;
    		ans[i][1] = p.k;
    	}
    	return ans;
    }
}