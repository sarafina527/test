public class NumArray {
	private int[] sum;
	int leaflow=0;
	int leafhigh=-1;
    public NumArray(int[] nums) {
        if(nums.length>0){
            sum = new int[nums.length<<2];
            leaflow = 0;
            leafhigh = nums.length-1;
            bulidTree(nums,0,nums.length-1,0);
        }
    }
    public void update(int i, int val) {
        update(leaflow,leafhigh,0,i,val);
    }    
    public int sumRange(int i, int j) {
        int[] ans = new int[1];
        query(leaflow,leafhigh,i,j,0,ans);
        return ans[0];
    }
    public int leftChild(int i){
    	return 2*i+1;
    }
    public int rightChild(int i){
    	return 2*i+2;
    }
    public int parent(int i){
    	return (i-1)/2;
    }
    public void bulidTree(int []nums,int p,int q,int root){
        //System.out.println(p+" "+q+" "+root);
        if(p>q) return;
    	if(p==q) sum[root] = nums[p];
    	else{
    		int m = p+(q-p)/2;
    		bulidTree(nums,p,m,leftChild(root));
    		bulidTree(nums,m+1,q,rightChild(root));
    		sum[root] = sum[leftChild(root)]+sum[rightChild(root)];
    	}
    }
    public void update(int p,int q,int root,int i,int val){
        if(p>q) return;
    	if(p==q) sum[root] = val;
    	else{
    		int m = p+(q-p)/2;
    		if(i<=m) update(p,m,leftChild(root),i,val);
    		else update(m+1,q,rightChild(root),i,val);
    		sum[root] = sum[leftChild(root)]+sum[rightChild(root)];
    	}
    }
    public void query(int p,int q,int rl,int rr,int root,int[] ans){
        if(p>q) return;
    	if(p>=rl&&q<=rr)
    		ans[0]+=sum[root];
    	else{
    		int m = p+(q-p)/2;
    		if(rl<=m) query(p,m,rl,rr,leftChild(root),ans);
    		if(rr>m) query(m+1,q,rl,rr,rightChild(root),ans);
    	}

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */