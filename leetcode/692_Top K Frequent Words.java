class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> wcnt = new HashMap<String,Integer>();
        for(String str:words){
            if(wcnt.containsKey(str)){
                wcnt.put(str,wcnt.get(str)+1);
            }else{
                wcnt.put(str,1);
            }
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(k,new Comparator<String>(){
            public int compare(String str1,String str2){
                if(wcnt.get(str1)==wcnt.get(str2))
                    return str2.compareTo(str1);
                else
                    return wcnt.get(str1)-wcnt.get(str2);
            }
        });
        int i=0;
        for(String str:wcnt.keySet()){
            //System.out.println(str+" "+wcnt.get(str));
            if(i++<k){
                heap.add(str);
            }else{
                String head = heap.peek();
                if(wcnt.get(str)>wcnt.get(head)||(wcnt.get(str)==wcnt.get(head)&&str.compareTo(head)<0)){
                    heap.poll();
                    heap.add(str);
                }
            }
        }
        List<String> ans = new LinkedList<String>();
        while(!heap.isEmpty()){
            ans.add(heap.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
