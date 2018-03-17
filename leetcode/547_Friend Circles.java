public class Solution {
    public int findCircleNum(int[][] M) {
    	if(M==null||M.length==0||M[0].length==0) return 0;
    	int n = M.length;
    	UnionFind ufs = new UnionFind(n);
        for(int i=0;i<n;i++){
        	for(int j=0;j<n;j++){
        		if(M[i][j]==1)
        			ufs.union(i,j);
        	}
        }
        return ufs.groupNums();
    }
}
class UnionFind{
	int[] par;
	int[] rank;
	UnionFind(int n){
		par = new int[n];
		rank = new int[n];
		for(int i=0;i<n;i++){
			par[i] = i;
			rank[i] = 0;
		}
	}
	public int find(int x){
		if(par[x]==x)
			return x;
		par[x] = find(par[x]);
		return par[x];
	}
	public void union(int x,int y){
		x = find(x);
		y = find(y);
		if(x==y) return;
		if(rank[x]<rank[y]){
			par[x]=y;
		}else if(rank[x]>rank[y]){
			par[y]=x;
		}else{
			par[x]=y;
			rank[y]++;
		}
	}
	public boolean inSameGroup(int x,int y){
		return find(x)==find(y);
	}
	public int groupNums(){
		int ans=0;
		for(int i=0;i<par.length;i++){
			if(par[i]==i)
				ans++;
		}
		return ans;
	}
}