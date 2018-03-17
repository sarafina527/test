class myComparator implements Comparator<T>
{
	public int compare(T o1,T o2){
		int asc = o1.toString().compareTo(o2.toString())
		return -asc;//小于返回>0 
	}

}
public class Solution {
    public int findKthNumber(int n, int k) {
    	myComparator cmp = new myComparator();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k,cmp);
        for(int i=1;i<=k;i++){
        	pq.add(i);
        }
        for(int i=k+1;i<=n;i++){
        	if(cmp.compare(i,pq.peek())>0){
        		pq.poll();
        		pq.add(i);
        	}
        }
        return pq.peek();

    }
}