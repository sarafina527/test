public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){//store the frequent
        	if(freq.containsKey(nums[i]))
        		freq.put(nums[i],freq.get(nums[i])+1);
        	else
        		freq.put(nums[i],1);
        }
        PriorityQueue<Map.Entry<Integer,Integer> > pq = new PriorityQueue<Map.Entry<Integer,Integer> >(k,new Comparator<Map.Entry<Integer,Integer> >(){
        	public int compare(Map.Entry<Integer,Integer> o1,Map.Entry<Integer,Integer> o2){
        		return o1.getValue()-o2.getValue();
        	}
        });
        int cnt = 0;
        for(Map.Entry<Integer,Integer> e:freq.entrySet()){
        	if(cnt++<k){
        		pq.offer(e);
        	}else{
        		if(e.getValue() > pq.peek().getValue()){
        			pq.poll();
        			pq.offer(e);
        		}
        	}
        }
        List<Map.Entry<Integer,Integer> > list = new LinkedList<Map.Entry<Integer,Integer> >(pq);
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer> >(){
        	public int compare(Map.Entry<Integer,Integer> o1,Map.Entry<Integer,Integer> o2){
        		return o2.getValue()-o1.getValue();
        	}
        });
        List<Integer> ans = new LinkedList<Integer>();
        for(Map.Entry<Integer,Integer> e:list){
        	ans.add(e.getKey());
        }
        return ans;
    }
}